package com.tharsis.deck_of_cards.di

import com.tharsis.deck_of_cards.domain.usecase.GetNewCardsUseCase
import com.tharsis.deck_of_cards.domain.usecase.GetNewDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReshuffleDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReturnCardsToDeckUseCase
import com.tharsis.deck_of_cards.presentation.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val cardGameModule = module {
    factory { GetNewDeckUseCase(get()) }
    factory { ReshuffleDeckUseCase(get()) }
    factory { ReturnCardsToDeckUseCase(get()) }
    factory { GetNewCardsUseCase(get()) }

    viewModel {
        HomeViewModel(
            reshuffleDeckUseCase = get(),
            getNewDeckUseCase = get(),
            returnCardsToDeckUseCase = get(),
            getNewCardsUseCase = get()
        )
    }
}