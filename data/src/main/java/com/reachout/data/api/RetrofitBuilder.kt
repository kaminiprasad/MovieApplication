package com.reachout.data.api

import com.reachout.data.util.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(OAuthInterceptor())
        .readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    class OAuthInterceptor() : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

            val request = chain.request().newBuilder().build()
            var response: Response? = null
            var isSuccess = false
            var tryCount = 0
            while (!isSuccess && tryCount < 3) {
                try {
                    response = chain.proceed(request)
                    isSuccess = response.isSuccessful
                } catch (e: java.lang.Exception) {
                    println("Interceptor Request is not successful - $tryCount")
                } finally {
                    tryCount++
                }
            }
            return response!!

        }
    }
}