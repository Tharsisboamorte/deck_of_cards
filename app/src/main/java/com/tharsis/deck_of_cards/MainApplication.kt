package com.tharsis.deck_of_cards

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.size.Precision
import com.tharsis.deck_of_cards.di.appModule
import com.tharsis.deck_of_cards.di.cardGameModule
import com.tharsis.deck_of_cards.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val imageLoader = ImageLoader.Builder(this)
            .crossfade(true)
            .precision(Precision.EXACT)
            .components {
                add(factory = SvgDecoder.Factory())
            }
            .build()

        Coil.setImageLoader(imageLoader)

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    cardGameModule,
                ),
            )
        }
    }
}