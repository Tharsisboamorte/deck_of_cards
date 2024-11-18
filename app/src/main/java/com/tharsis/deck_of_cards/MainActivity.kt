package com.tharsis.deck_of_cards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tharsis.deck_of_cards.presentation.home.HomeScreen
import com.tharsis.deck_of_cards.presentation.home.HomeViewModel
import com.tharsis.deck_of_cards.utils.theme.Deck_of_cardsTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinContext {
                Deck_of_cardsTheme {
                    val viewModel: HomeViewModel = getViewModel()
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}