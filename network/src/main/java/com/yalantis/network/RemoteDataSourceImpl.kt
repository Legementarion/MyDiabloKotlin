package com.yalantis.network

import com.yalantis.core.datasources.RemoteHeroesDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class RemoteDataSourceImpl(private val blizzardUrl: String): RemoteHeroesDataSource {

    val blizzardApi: BlizzardApi

    init {
//        val typeToken = object : TypeToken<Result>() {}.type
//        val gson = JacksonBuilder()
//                .registerTypeAdapter(typeToken, GsonDeserializer<Hero>())
//                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(blizzardUrl)
                .client(OkHttpClient())
//                .addConverterFactory(JacksonConverterFactory.create(gson))
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