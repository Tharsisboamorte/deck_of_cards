package com.tharsis.deck_of_cards

import android.app.Application
import com.tharsis.deck_of_cards.di.appModule
import com.tharsis.deck_of_cards.di.networkModule
import com.tharsis.deck_of_cards.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    useCaseModule,
                ),
            )
        }
    }
}