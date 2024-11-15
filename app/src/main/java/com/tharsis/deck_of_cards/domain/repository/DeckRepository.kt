package com.tharsis.deck_of_cards.domain.repository

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.utils.common.Resource

interface DeckRepository {
    suspend fun getDeck(): Resource<DeckResponse>
    suspend fun reshuffleDeck(deckId: String): Resource<DeckResponse>
    suspend fun returnCardsToDeck(deckId: String): Resource<DeckResponse>
}