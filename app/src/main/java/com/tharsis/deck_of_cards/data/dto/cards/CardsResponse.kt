package com.tharsis.deck_of_cards.data.dto.cards

import com.google.gson.annotations.SerializedName

data class CardsResponse(

    @SerializedName("code") var code: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("images") var images: ImagesResponse? = ImagesResponse(),
    @SerializedName("value") var value: String? = null,
    @SerializedName("suit") var suit: String? = null

)

data class ImagesResponse(

    @SerializedName("svg") var svg: String? = null,
    @SerializedName("png") var png: String? = null

)