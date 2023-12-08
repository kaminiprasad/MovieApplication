package com.reachout.data.api

import com.reachout.data.model.Animal
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("animals/rand/{id}")
    suspend fun getAnimalList(@Path("id") number: Int): List<Animal>

    @GET("books/v1/volumes")
    suspend fun getBooks(@Query("q") author: String): Response<Animal>

    @POST("sdsg/Question")
    suspend fun createRequestBodyData(@Body requestBody: RequestBody): ResponseBody

    @GET("/Request/{requestId}")
    suspend fun getUnifiedData(@Path("requestId") requestId: String): Response<ResponseBody>
}