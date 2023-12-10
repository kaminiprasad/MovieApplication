package com.reachout.domain.di

import com.reachout.domain.usecase.GetPopularMovieUseCase
import com.reachout.domain.usecase.GetPopularMovieUseCaseImpl
import com.reachout.domain.usecase.MovieDetailsUseCase
import com.reachout.domain.usecase.MovieDetailsUseCaseImpl
import com.reachout.domain.usecase.artist.MovieArtistUseCase
import com.reachout.domain.usecase.artist.MovieArtistUseCaseImpl
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