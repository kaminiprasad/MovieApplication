package com.reachout.app.animal.presentation.di

import com.reachout.domain.repository.Repository
import com.reachout.domain.usecase.GetPopularMovieUseCaseImpl
import com.reachout.domain.usecase.MovieDetailsUseCaseImpl
import com.reachout.domain.usecase.artist.MovieArtistUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UIModule {
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