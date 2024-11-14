package com.tharsis.deck_of_cards.data.remote.service

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.domain.common.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface DeckApiService {

    @GET(ApiEndpoint.GET_DECK)
    suspend fun getNewDeck(): DeckResponse

    @GET(ApiEndpoint.RESHUFFLE_CARDS)
    suspend fun getReshuffledDeck(@Path("deck_id") deckId: String): DeckResponse

    @GET(ApiEndpoint.RETURN_TO_DECK)
    suspend fun returnCardsToDeck(@Path("deck_id") deckId: String): DeckResponse
}