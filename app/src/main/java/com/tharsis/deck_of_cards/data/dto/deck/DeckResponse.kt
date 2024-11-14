package com.tharsis.deck_of_cards.data.dto.deck

import com.google.gson.annotations.SerializedName
import com.tharsis.deck_of_cards.data.dto.cards.CardsResponse

data class DeckResponse(
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("deck_id") var deckId: String? = null,
    @SerializedName("cards") var cards: ArrayList<CardsResponse>? = arrayListOf(),
    @SerializedName("shuffled") var shuffled: Boolean? = null,
    @SerializedName("remaining") var remaining: Int? = null,
    @SerializedName("piles") var piles: Piles? = Piles()
)

data class Piles(
    @SerializedName("discard") var discard: Discard? = Discard()
)

data class Discard(
    @SerializedName("remaining") var remaining: Int? = null
)

