package com.movie.data.di

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
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class NetworkUseCaseModule {
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