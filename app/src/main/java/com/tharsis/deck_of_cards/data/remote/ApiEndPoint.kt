package com.tharsis.deck_of_cards.data.remote

import com.tharsis.deck_of_cards.BuildConfig

object ApiEndPoint {

    const val SHUFFLE_CARDS = "${BuildConfig.BASE_URL}new/draw/?count=4"

    const val RESHUFFLE_CARDS = "${BuildConfig.BASE_URL}{deck_id}/shuffle/"

    const val RETURN_TO_DECK = "${BuildConfig.BASE_URL}{deck_id}/return/"

}