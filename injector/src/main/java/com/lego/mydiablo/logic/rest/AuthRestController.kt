package com.lego.mydiablo.logic.rest

import android.util.Base64
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class AuthRestController {

    private val authApi: AutorizationApi

    init {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original: Request = chain.request()

                    val requestBuilder = original.newBuilder()
                            .header("Autorization", "Basic"
                                    + Base64.encodeToString("".toByteArray(), Base64.NO_WRAP))
                            .method(original.method(), original.body())
                    val request: Request = requestBuilder.build()
                    chain.proceed(request)
                }
                .addInterceptor(logInterceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("")
                .client(okClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build()

        authApi = retrofit.create(AutorizationApi::class.java)
    }

}