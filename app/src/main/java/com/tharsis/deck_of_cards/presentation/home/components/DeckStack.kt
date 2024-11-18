package com.tharsis.deck_of_cards.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.tharsis.deck_of_cards.R

@Composable
fun DeckStack(cards: Int) {
    repeat(cards){ index ->
        Box(
            modifier = Modifier
                .size(90.dp, 100.dp)
                .zIndex(-index.toFloat())
                .offset(x = (index * 3.2).dp, y = (index * 2.8).dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_of_card),
                contentDescription = R.string.back_card_description.toString(),
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
fun DeckStackPreview() {
    DeckStack(cards = 49)
}