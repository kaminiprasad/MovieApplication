package com.movie.data.di

import com.movie.data.util.RequestInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.Interceptor

@Module
@InstallIn(ViewModelComponent::class)
abstract class NetworkRequestModule {
    @Binds
    abstract fun bindRequestInterceptor(reqInterceptor: RequestInterceptor): Interceptor
}
