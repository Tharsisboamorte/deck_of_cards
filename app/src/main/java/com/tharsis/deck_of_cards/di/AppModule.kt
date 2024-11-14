package com.tharsis.deck_of_cards.di

import com.tharsis.deck_of_cards.data.network.Network
import com.tharsis.deck_of_cards.data.network.NetworkConnectivity
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext


val appModule = module {

    single<CoroutineContext>{ Dispatchers.IO }

    single<NetworkConnectivity>{ Network(androidContext()) }
}