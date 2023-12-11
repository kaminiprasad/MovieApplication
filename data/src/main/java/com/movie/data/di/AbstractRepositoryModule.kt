package com.movie.data.di

import com.movie.data.repository.RepositoryImpl
import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.movie.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractRepositoryModule {
    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindRemoteDataSource(remoteSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}