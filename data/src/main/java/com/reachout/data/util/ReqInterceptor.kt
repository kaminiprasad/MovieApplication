package com.reachout.data.util

import com.reachout.data.util.Constants.API_KEY
import com.reachout.data.util.Constants.MOVIE_API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class ReqInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter(
                API_KEY,
                MOVIE_API_KEY
            )
            .build()
        val request = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(request)
    }
}