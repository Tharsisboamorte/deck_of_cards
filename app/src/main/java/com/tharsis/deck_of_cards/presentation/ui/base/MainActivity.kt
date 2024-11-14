package com.tharsis.deck_of_cards.presentation.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tharsis.deck_of_cards.presentation.ui.theme.Deck_of_cardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Deck_of_cardsTheme {

            }
        }
    }
}