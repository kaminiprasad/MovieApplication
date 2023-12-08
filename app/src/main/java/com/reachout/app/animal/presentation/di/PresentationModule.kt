package com.reachout.app.animal.presentation.di

import com.reachout.domain.repository.Repository
import com.reachout.domain.usecase.GetItemUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideItemUseCase(repository: Repository): GetItemUseCaseImpl {
        return GetItemUseCaseImpl(repository)
    }
}