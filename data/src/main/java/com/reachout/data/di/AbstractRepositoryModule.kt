package com.reachout.data.di

import com.reachout.data.repository.RepositoryImpl
import com.reachout.data.repository.datasource.RemoteDataSource
import com.reachout.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.reachout.domain.repository.Repository
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