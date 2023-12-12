package com.movie.domain.di

import com.movie.domain.usecase.popularmovie.GetPopularMovieUseCase
import com.movie.domain.usecase.popularmovie.GetPopularMovieUseCaseImpl
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCaseImpl
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.artist.MovieArtistUseCaseImpl
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun provideMovieArtistUseCase(useCase: MovieArtistUseCaseImpl): MovieArtistUseCase

    @Binds
    abstract fun provideGetPopularMovieUseCase(useCase: GetPopularMovieUseCaseImpl): GetPopularMovieUseCase

    @Binds
    abstract fun provideMovieDetailsUseCase(useCase: MovieDetailsUseCaseImpl): MovieDetailsUseCase
}