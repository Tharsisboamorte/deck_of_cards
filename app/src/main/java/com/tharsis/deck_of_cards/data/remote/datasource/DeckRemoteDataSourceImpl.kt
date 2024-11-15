package com.tharsis.deck_of_cards.data.remote.datasource

import com.tharsis.deck_of_cards.data.dto.deck.Deck
import com.tharsis.deck_of_cards.utils.network.safeApiCall
import com.tharsis.deck_of_cards.data.remote.service.DeckApiService
import com.tharsis.deck_of_cards.utils.common.Resource

class DeckRemoteDataSourceImpl(private val apiService: DeckApiService) : DeckRemoteDataSource {
    override suspend fun getNewDeck(): Resource<Deck> {
        return safeApiCall { apiService.getNewDeck() }
    }

    override suspend fun reshuffleDeck(deckId: String): Resource<Deck> {
        return safeApiCall { apiService.getReshuffledDeck(deckId) }
    }

    override suspend fun returnCardsToDeck(deckId: String): Resource<Deck> {
        return safeApiCall { apiService.returnCardsToDeck(deckId) }
    }
}