package ru.sr.storage.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.sr.storage.remote.HotelApi

fun apiModule() = listOf(retrofitModule())

internal fun retrofitModule() = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<HotelApi> { get<Retrofit>().create() }
}