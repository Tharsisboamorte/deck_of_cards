package com.tharsis.deck_of_cards.domain.model

data class Card(
    val code: String = "",
    val image: String = "",
    val cardImages: CardImages = CardImages(),
    val value: String = "",
    val suit: String = ""
)