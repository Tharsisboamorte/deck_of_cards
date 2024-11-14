package com.tharsis.deck_of_cards.domain.repository

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.domain.common.Resource

interface DeckRepository {
    suspend fun getDeck(): Resource<DeckResponse>
    suspend fun reshuffleDeck(): Resource<DeckResponse>
    suspend fun returnCardsToDeck(): Resource<DeckResponse>
}