package com.movie.data.di

import com.movie.data.api.ApiService
import com.movie.data.mapper.mapperimpl.MovieDetailMapperImpl
import com.movie.data.mapper.mapperimpl.MovieListMapperImpl
import com.movie.data.repository.RepositoryImpl
import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.movie.domain.repository.Repository
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCaseImpl
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import com.movie.domain.usecase.popularmovie.PopularMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class NetworkUseCaseModule {
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
    ): Repository = RepositoryImpl(
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
    fun provideRemoteDataSource(
        apiService: ApiService,
        listMapper: MovieListMapperImpl,
        movieDetailMapper: MovieDetailMapperImpl,
    ): RemoteDataSource {
        return RemoteDataSourceImpl(apiService, listMapper, movieDetailMapper)
    }
}
