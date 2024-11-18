package com.tharsis.deck_of_cards.data.remote.service

object ApiEndpoint {

    const val GET_DECK = "new/draw/?count=3"

    const val DRAW_DECK = "{deck_id}/draw/?count=3"

    const val RESHUFFLE_CARDS = "{deck_id}/shuffle/"

    const val RETURN_TO_DECK = "{deck_id}/return/"

}