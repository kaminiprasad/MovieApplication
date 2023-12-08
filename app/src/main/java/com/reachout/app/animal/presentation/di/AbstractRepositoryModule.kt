package com.reachout.app.animal.presentation.di

import com.reachout.data.repository.RepositoryImpl
import com.reachout.data.repository.datasource.LocalDataSource
import com.reachout.data.repository.datasource.RemoteDataSource
import com.reachout.data.repository.datasourceimpl.LocalDataSourceImpl
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
    abstract fun bindLocalSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteSource(remoteSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}