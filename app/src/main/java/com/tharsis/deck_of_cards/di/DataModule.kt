package com.tharsis.deck_of_cards.di

import com.tharsis.deck_of_cards.data.repository.DeckRepositoryImpl
import org.koin.dsl.module

val dataModule =  module {
    single { DeckRepositoryImpl(get()) }
}