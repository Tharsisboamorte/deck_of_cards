package com.tharsis.deck_of_cards.data.remote.datasource

import com.tharsis.deck_of_cards.data.dto.deck.Deck
import com.tharsis.deck_of_cards.utils.common.Resource

interface DeckRemoteDataSource {
    suspend fun getNewDeck(): Resource<Deck>
    suspend fun reshuffleDeck(deckId: String): Resource<Deck>
    suspend fun returnCardsToDeck(deckId: String): Resource<Deck>
}