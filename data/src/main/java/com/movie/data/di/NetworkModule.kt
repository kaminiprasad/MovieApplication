package com.movie.data.di

import com.movie.data.api.ApiService
import com.movie.data.repository.RepositoryImpl
import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.movie.data.util.Constants
import com.movie.data.util.ReqInterceptor
import com.movie.domain.repository.Repository
import com.movie.domain.usecase.GetPopularMovieUseCaseImpl
import com.movie.domain.usecase.MovieDetailsUseCaseImpl
import com.movie.domain.usecase.artist.MovieArtistUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkhttpInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
//                .addHeader("Accept", "Application/JSON")
            val request: Request = requestBuilder.build()
            var response: Response? = null
            var isSuccess = false
            var tryCount = 0
            while (!isSuccess && tryCount < 3) {
                try {
                    response = chain.proceed(request)
                    isSuccess = response.isSuccessful
                } catch (e: java.lang.Exception) {
                    println("Request is not successful - $tryCount")
                } finally {
                    tryCount++
                }
            }
            response!!

        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ReqInterceptor())
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
        gsonConverterFactory: GsonConverterFactory
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
    fun provideIoDispatcher() = Dispatchers.IO

    @Provides
    fun provideRemoteSource(apiService: ApiService) = RemoteDataSourceImpl(apiService)

    @Provides
    fun provideRepository(
        ioDispatcher: CoroutineDispatcher,
        remoteDataSource: RemoteDataSource
    ) = RepositoryImpl(
        dispatcher = ioDispatcher,
        remoteDataSource = remoteDataSource
    )

    @Provides
    fun provideMovieUseCase(repository: Repository): GetPopularMovieUseCaseImpl {
        return GetPopularMovieUseCaseImpl(repository)
    }

    @Provides
    fun provideMovieDetailsUseCase(repository: Repository): MovieDetailsUseCaseImpl {
        return MovieDetailsUseCaseImpl(repository)
    }

    @Provides
    fun provideMovieArtistUseCase(repository: Repository): MovieArtistUseCaseImpl {
        return MovieArtistUseCaseImpl(repository)
    }
}