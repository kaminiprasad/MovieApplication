package com.movie.data.di

import com.movie.data.api.ApiService
import com.movie.data.repository.RepositoryImpl
import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.movie.data.util.Constants
import com.movie.data.util.RequestInterceptor
import com.movie.domain.repository.Repository
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.artist.MovieArtistUseCaseImpl
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCaseImpl
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import com.movie.domain.usecase.popularmovie.PopularMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: RequestInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .callTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideRemoteDataSource(apiService: ApiService) = RemoteDataSourceImpl(apiService)

    @Provides
    fun provideRepository(
        ioDispatcher: CoroutineDispatcher,
        remoteDataSource: RemoteDataSource,
    ) = RepositoryImpl(
        dispatcher = ioDispatcher,
        remoteDataSource = remoteDataSource,
    )

    @Provides
    fun provideMovieUseCase(repository: Repository): PopularMovieUseCase {
        return PopularMovieUseCaseImpl(repository)
    }

    @Provides
    fun provideMovieDetailsUseCase(repository: Repository): MovieDetailsUseCase {
        return MovieDetailsUseCaseImpl(repository)
    }

    @Provides
    fun provideMovieArtistUseCase(repository: Repository): MovieArtistUseCase {
        return MovieArtistUseCaseImpl(repository)
    }
}
