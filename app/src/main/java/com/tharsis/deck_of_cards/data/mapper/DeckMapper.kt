package com.tharsis.deck_of_cards.data.mapper

import com.tharsis.deck_of_cards.data.dto.deck.DiscardResponse
import com.tharsis.deck_of_cards.data.dto.deck.PilesResponse
import com.tharsis.deck_of_cards.domain.model.Deck
import com.tharsis.deck_of_cards.domain.model.Discard
import com.tharsis.deck_of_cards.domain.model.Piles

fun com.tharsis.deck_of_cards.data.dto.deck.Deck.toDomain(): Deck {
    return Deck(
        success = this.success ?: false,
        id = this.deckId.orEmpty(),
        cards = this.cards?.map { it.toDomain() } ?: emptyList(),
        isShuffled = this.shuffled ?: false,
        remainingCards = this.remaining ?: 0,
        piles = this.pilesResponse?.toDomain() ?: Piles()
    )
}
fun PilesResponse.toDomain(): Piles {
    return Piles(
        discard = this.discardResponse?.toDomain() ?: Discard()
    )
}

fun DiscardResponse.toDomain(): Discard {
    return Discard(
        remaining = this.remaining ?: 0
    )
}
