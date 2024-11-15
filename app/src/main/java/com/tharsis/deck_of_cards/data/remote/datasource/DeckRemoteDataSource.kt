package com.tharsis.deck_of_cards.data.remote.datasource

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.utils.common.Resource

interface DeckRemoteDataSource {
    suspend fun getNewDeck(): Resource<DeckResponse>
    suspend fun reshuffleDeck(deckId: String): Resource<DeckResponse>
    suspend fun returnCardsToDeck(deckId: String): Resource<DeckResponse>
}