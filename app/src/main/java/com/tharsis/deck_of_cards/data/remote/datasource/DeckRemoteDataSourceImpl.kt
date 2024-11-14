package com.tharsis.deck_of_cards.data.remote.datasource

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.data.network.util.safeApiCall
import com.tharsis.deck_of_cards.data.remote.service.DeckApiService
import com.tharsis.deck_of_cards.domain.common.Resource

class DeckRemoteDataSourceImpl(private val apiService: DeckApiService) : DeckRemoteDataSource {
    override suspend fun getNewDeck(): Resource<DeckResponse> {
        return safeApiCall { apiService.getNewDeck() }
    }

    override suspend fun reshuffleDeck(deckId: String): Resource<DeckResponse> {
        return safeApiCall { apiService.getReshuffledDeck(deckId) }
    }

    override suspend fun returnCardsToDeck(deckId: String): Resource<DeckResponse> {
        return safeApiCall { apiService.returnCardsToDeck(deckId) }
    }
}