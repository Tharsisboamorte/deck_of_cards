package com.tharsis.deck_of_cards.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tharsis.deck_of_cards.R
import com.tharsis.deck_of_cards.presentation.home.components.CardGrid
import com.tharsis.deck_of_cards.presentation.home.components.DeckStack
import com.tharsis.deck_of_cards.utils.theme.MainGreen
import org.koin.compose.getKoin
import org.koin.core.annotation.KoinInternalApi

@OptIn(KoinInternalApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedBoxWithConstraintsScope")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {

    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getNewDeck()
    }

    Scaffold(
        containerColor = MainGreen,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = Color.Transparent)
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 25.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top,
            ) {
                IconButton(
                    onClick = { viewModel.getReshuffledDeck(viewModel.currentDeckId) },
                ) {
                    Icon(
                        modifier = Modifier.size(height = 25.dp, width = 50.dp),
                        painter = painterResource(id = R.drawable.sync_reverse_ic),
                        contentDescription = "Reverse Icon for reshuffling deck",
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(innerPadding),
                contentAlignment = Alignment.TopCenter
            ) {
                DeckStack(cards = 6)
            }
            Spacer(modifier = Modifier.height(32.dp))
            when (viewState) {
                is CardGameUiState.Loading -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            color = Color.Black
                        )
                    }
                }

                is CardGameUiState.Success -> {
                    val deck = (viewState as CardGameUiState.Success).deck
                    getKoin().logger.info(msg = " DECK LENGTH : ${deck.remainingCards}")
                    CardGrid(deck = deck.cards)
                }

                is CardGameUiState.Error -> {
                    val errorMessage = (viewState as CardGameUiState.Error).message
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Error: $errorMessage",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                is CardGameUiState.ReshuffledState -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}