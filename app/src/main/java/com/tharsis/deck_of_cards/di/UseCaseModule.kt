package com.tharsis.deck_of_cards.di

import com.tharsis.deck_of_cards.domain.usecase.GetNewDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReshuffleDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReturnCardsToDeckUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetNewDeckUseCase(get()) }
    factory { ReshuffleDeckUseCase(get()) }
    factory { ReturnCardsToDeckUseCase(get()) }
}