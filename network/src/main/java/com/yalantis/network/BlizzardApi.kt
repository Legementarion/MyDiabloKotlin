package com.yalantis.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface BlizzardApi {

    // TODO write  query here

    companion object Factory {
        fun create(): BlizzardApi {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/") //todo provide real url
                    .build()

            return retrofit.create(BlizzardApi::class.java)
        }
    }
}