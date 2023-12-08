package com.reachout.data.di

/*
import android.content.Context
import androidx.room.Room
import com.reachout.data.api.ApiService
import com.reachout.data.api.RetrofitBuilder
import com.reachout.data.db.Dao
import com.reachout.data.db.Database
import com.reachout.data.repository.RepositoryImpl
import com.reachout.data.repository.datasource.LocalDataSource
import com.reachout.data.repository.datasource.RemoteDataSource
import com.reachout.data.repository.datasourceimpl.LocalDataSourceImpl
import com.reachout.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.reachout.data.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideOkhttpInterceptor() : Interceptor{
        return  Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
//                .addHeader("Accept", "Application/JSON")
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(interceptor)
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
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


//    @Provides
//    fun provideApiService(): ApiService =
//        RetrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Provides
    fun provideLocalSource(dao: Dao): LocalDataSourceImpl {
        return LocalDataSourceImpl(dao)
    }

    @Provides
    fun provideRemoteSource(apiService: ApiService): RemoteDataSourceImpl {
        return RemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideRepository(
        ioDispatcher: CoroutineDispatcher,
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): RepositoryImpl {
        return RepositoryImpl(
            dispatcher = ioDispatcher,
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Database.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDao(database: Database): Dao {
        return database.getZooDao()
    }
}*/
