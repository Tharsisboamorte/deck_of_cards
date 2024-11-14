package com.tharsis.deck_of_cards.data.remote.service

import com.tharsis.deck_of_cards.BuildConfig

object ApiEndpoint {

    const val GET_DECK = "${BuildConfig.BASE_URL}new/draw/?count=4"

    const val RESHUFFLE_CARDS = "${BuildConfig.BASE_URL}{deck_id}/shuffle/"

    const val RETURN_TO_DECK = "${BuildConfig.BASE_URL}{deck_id}/return/"

}