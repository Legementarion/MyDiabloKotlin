package com.yalantis.network

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.yalantis.core.datasources.RemoteHeroesDataSource
import com.yalantis.core.models.Hero
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSourceImpl(private val blizzardUrl: String): RemoteHeroesDataSource {

    private val blizzardApi: BlizzardApi

    init {
//        val typeToken = object : TypeToken<Result>() {}.type
        val gson = GsonBuilder()
//                .registerTypeAdapter(typeToken, GsonDeserializer<Hero>())
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(blizzardUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        blizzardApi = retrofit.create(BlizzardApi::class.java)
    }

    override fun findTopHeroesBySpec() {
        TODO("not implemented")
    }

    override fun searchByName(query: String) {
        TODO("not implemented")
    }

}