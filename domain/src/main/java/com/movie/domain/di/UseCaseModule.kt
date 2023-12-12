package com.movie.domain.di

import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.artist.MovieArtistUseCaseImpl
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCaseImpl
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import com.movie.domain.usecase.popularmovie.PopularMovieUseCaseImpl
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun provideMovieArtistUseCase(useCase: MovieArtistUseCaseImpl): MovieArtistUseCase

    @Binds
    abstract fun provideGetPopularMovieUseCase(useCase: PopularMovieUseCaseImpl): PopularMovieUseCase

    @Binds
    abstract fun provideMovieDetailsUseCase(useCase: MovieDetailsUseCaseImpl): MovieDetailsUseCase
}
