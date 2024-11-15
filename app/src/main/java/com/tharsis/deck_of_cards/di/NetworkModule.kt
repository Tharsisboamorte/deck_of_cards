package com.tharsis.deck_of_cards.di

import com.tharsis.deck_of_cards.BuildConfig
import com.tharsis.deck_of_cards.data.remote.datasource.DeckRemoteDataSource
import com.tharsis.deck_of_cards.data.remote.datasource.DeckRemoteDataSourceImpl
import com.tharsis.deck_of_cards.data.remote.service.DeckApiService
import com.tharsis.deck_of_cards.data.repository.DeckRepositoryImpl
import com.tharsis.deck_of_cards.domain.repository.DeckRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DeckApiService::class.java)
    }

    single<DeckRemoteDataSource> { DeckRemoteDataSourceImpl(get()) }
    single<DeckRepository> { DeckRepositoryImpl(get()) }
}