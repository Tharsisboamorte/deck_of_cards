package com.tharsis.deck_of_cards.data.dto.deck

import com.google.gson.annotations.SerializedName
import com.tharsis.deck_of_cards.data.dto.cards.CardsResponse

data class Deck(
    @SerializedName("success") val success: Boolean? = null,
    @SerializedName("deck_id") val deckId: String? = null,
    @SerializedName("cards") val cards: ArrayList<CardsResponse>? = arrayListOf(),
    @SerializedName("shuffled") val shuffled: Boolean? = null,
    @SerializedName("remaining") val remaining: Int? = null,
    @SerializedName("piles") val pilesResponse: PilesResponse? = PilesResponse()
)

data class PilesResponse(
    @SerializedName("discard") val discardResponse: DiscardResponse? = DiscardResponse()
)

data class DiscardResponse(
    @SerializedName("remaining") val remaining: Int? = null
)

