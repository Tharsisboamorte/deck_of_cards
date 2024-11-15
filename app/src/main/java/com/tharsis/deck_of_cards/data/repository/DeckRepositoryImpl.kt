package com.tharsis.deck_of_cards.data.repository

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.data.remote.datasource.DeckRemoteDataSource
import com.tharsis.deck_of_cards.domain.repository.DeckRepository
import com.tharsis.deck_of_cards.utils.common.Resource

class DeckRepositoryImpl(private val deckRemoteDataSource: DeckRemoteDataSource) : DeckRepository {
    override suspend fun getDeck(): Resource<DeckResponse> {
        return deckRemoteDataSource.getNewDeck()
    }

    override suspend fun reshuffleDeck(deckId: String): Resource<DeckResponse> {
        return deckRemoteDataSource.reshuffleDeck(deckId)
    }

    override suspend fun returnCardsToDeck(deckId: String): Resource<DeckResponse> {
        return deckRemoteDataSource.returnCardsToDeck(deckId)
    }

}