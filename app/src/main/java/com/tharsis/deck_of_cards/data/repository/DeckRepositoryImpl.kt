package com.tharsis.deck_of_cards.data.repository

import com.tharsis.deck_of_cards.data.mapper.toDomain
import com.tharsis.deck_of_cards.data.remote.datasource.DeckRemoteDataSource
import com.tharsis.deck_of_cards.domain.model.Deck
import com.tharsis.deck_of_cards.domain.repository.DeckRepository
import com.tharsis.deck_of_cards.utils.common.Resource

class DeckRepositoryImpl(private val deckRemoteDataSource: DeckRemoteDataSource) : DeckRepository {
    override suspend fun getDeck(): Resource<Deck> {
        return when (val response = deckRemoteDataSource.getNewDeck()) {
            is Resource.Success -> Resource.Success(response.data.toDomain())
            is Resource.DataError -> Resource.DataError(response.errorType, response.exception)
        }
    }

    override suspend fun reshuffleDeck(deckId: String): Resource<Deck> {
        return when (val response = deckRemoteDataSource.reshuffleDeck(deckId)) {
            is Resource.Success -> Resource.Success(response.data.toDomain())
            is Resource.DataError -> Resource.DataError(response.errorType, response.exception)
        }
    }

    override suspend fun returnCardsToDeck(deckId: String): Resource<Deck> {
        return when (val response = deckRemoteDataSource.returnCardsToDeck(deckId)) {
            is Resource.Success -> Resource.Success(response.data.toDomain())
            is Resource.DataError -> Resource.DataError(response.errorType, response.exception)
        }
    }

}