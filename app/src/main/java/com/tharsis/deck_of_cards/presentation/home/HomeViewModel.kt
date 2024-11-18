package com.tharsis.deck_of_cards.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tharsis.deck_of_cards.domain.model.Deck
import com.tharsis.deck_of_cards.domain.usecase.GetNewCardsUseCase
import com.tharsis.deck_of_cards.domain.usecase.GetNewDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReshuffleDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReturnCardsToDeckUseCase
import com.tharsis.deck_of_cards.utils.common.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNewDeckUseCase: GetNewDeckUseCase,
    private val reshuffleDeckUseCase: ReshuffleDeckUseCase,
    private val returnCardsToDeckUseCase: ReturnCardsToDeckUseCase,
    private val getNewCardsUseCase: GetNewCardsUseCase

) : ViewModel() {

    private val _viewState = MutableStateFlow<CardGameUiState>(CardGameUiState.Loading)
    val viewState: StateFlow<CardGameUiState> = _viewState
    var currentDeckId: String = ""

    fun getNewDeck() {
        _viewState.value = CardGameUiState.Loading
        viewModelScope.launch {
            val result = getNewDeckUseCase()
            _viewState.value = when (result) {
                is Resource.Success -> {
                    currentDeckId = result.data.id
                    CardGameUiState.Success(deck = result.data)
                }
                is Resource.DataError -> CardGameUiState.Error(
                    message = result.errorType.message
                )
            }
        }
    }

    private fun getNewCards(deckId: String) {
        viewModelScope.launch {
            val result = getNewCardsUseCase(deckId)
            _viewState.value = when (result) {
                is Resource.Success -> CardGameUiState.Success(deck = result.data)
                is Resource.DataError -> CardGameUiState.Error(
                    message = result.errorType.message
                )
            }
        }
    }

    private fun returnCardsToDeck(deckId: String) {
        viewModelScope.launch {
            val result = returnCardsToDeckUseCase(deckId)
            _viewState.value = when (result) {
                is Resource.Success -> CardGameUiState.Success(deck = result.data)
                is Resource.DataError -> CardGameUiState.Error(
                    message = result.errorType.message
                )
            }
        }
    }


    fun getReshuffledDeck(deckId: String) {
        _viewState.value = CardGameUiState.ReshuffledState
        returnCardsToDeck(deckId)
        viewModelScope.launch {
            when (val result = reshuffleDeckUseCase(deckId)) {
                is Resource.Success -> {
                    getNewCards(result.data.id)
                }
                is Resource.DataError -> CardGameUiState.Error(
                    message = result.errorType.message
                )
            }
        }
    }

}

sealed class CardGameUiState {
    data object Loading : CardGameUiState()
    data object ReshuffledState : CardGameUiState()
    data class Success(val deck: Deck) : CardGameUiState()
    data class Error(val message: String) : CardGameUiState()
}