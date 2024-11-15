package com.tharsis.deck_of_cards.domain.model

data class Deck(
    val success: Boolean,
    val id: String,
    val cards: List<Card> = emptyList(),
    val isShuffled: Boolean,
    val remainingCards: Int,
    val piles: Piles = Piles()
)

data class Piles(val discard: Discard = Discard())

data class Discard(val remaining: Int = 0)