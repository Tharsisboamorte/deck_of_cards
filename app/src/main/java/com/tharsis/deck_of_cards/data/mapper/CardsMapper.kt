package com.tharsis.deck_of_cards.data.mapper

import com.tharsis.deck_of_cards.data.dto.cards.CardsResponse
import com.tharsis.deck_of_cards.data.dto.cards.ImagesResponse
import com.tharsis.deck_of_cards.domain.model.Card
import com.tharsis.deck_of_cards.domain.model.CardImages

fun CardsResponse.toDomain(): Card {
    return Card(
        code = this.code.orEmpty(),
        image = this.image.orEmpty(),
        cardImages = this.images?.toDomain() ?: CardImages(),
        value = this.value.orEmpty(),
        suit = this.suit.orEmpty()
    )
}

fun ImagesResponse.toDomain(): CardImages {
    return CardImages(
        svg = this.svg.orEmpty(),
        png = this.png.orEmpty()
    )
}