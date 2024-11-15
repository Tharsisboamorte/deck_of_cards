package com.tharsis.deck_of_cards.data.dto.cards

import com.google.gson.annotations.SerializedName

data class CardsResponse(
    @SerializedName("code") val code: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("images") val images: ImagesResponse? = ImagesResponse(),
    @SerializedName("value") val value: String? = null,
    @SerializedName("suit") val suit: String? = null
)

data class ImagesResponse(
    @SerializedName("svg") val svg: String? = null,
    @SerializedName("png") val png: String? = null
)