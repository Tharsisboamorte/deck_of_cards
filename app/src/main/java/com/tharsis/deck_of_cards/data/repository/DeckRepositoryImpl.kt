package com.tharsis.deck_of_cards.data.repository

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.domain.common.Resource
import com.tharsis.deck_of_cards.data.remote.service.DeckApiService
import com.tharsis.deck_of_cards.domain.repository.DeckRepository

class DeckRepositoryImpl(private val deckApiService: DeckApiService) : DeckRepository {
    override suspend fun getDeck(): Resource<DeckResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun reshuffleDeck(): Resource<DeckResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun returnCardsToDeck(): Resource<DeckResponse> {
        TODO("Not yet implemented")
    }

}