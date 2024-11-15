package com.tharsis.deck_of_cards.domain.repository


import com.tharsis.deck_of_cards.domain.model.Deck
import com.tharsis.deck_of_cards.utils.common.Resource

interface DeckRepository {
    suspend fun getDeck(): Resource<Deck>
    suspend fun reshuffleDeck(deckId: String): Resource<Deck>
    suspend fun returnCardsToDeck(deckId: String): Resource<Deck>
}