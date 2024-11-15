package com.tharsis.deck_of_cards.data.remote.service

import com.tharsis.deck_of_cards.data.dto.deck.Deck
import retrofit2.http.GET
import retrofit2.http.Path

interface DeckApiService {

    @GET(ApiEndpoint.GET_DECK)
    suspend fun getNewDeck(): Deck

    @GET(ApiEndpoint.RESHUFFLE_CARDS)
    suspend fun getReshuffledDeck(@Path("deck_id") deckId: String): Deck

    @GET(ApiEndpoint.RETURN_TO_DECK)
    suspend fun returnCardsToDeck(@Path("deck_id") deckId: String): Deck
}