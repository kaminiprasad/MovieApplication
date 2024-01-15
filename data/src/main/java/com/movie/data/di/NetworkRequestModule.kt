package com.movie.data.di

import com.movie.data.util.RequestInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkRequestModule {
    @Binds
    abstract fun bindRequestInterceptor(reqInterceptor: RequestInterceptor): Interceptor
}
