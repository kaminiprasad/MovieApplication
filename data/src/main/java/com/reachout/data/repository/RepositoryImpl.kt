package com.reachout.data.repository

import com.reachout.data.mapper.AnimalDomainMapper
import com.reachout.data.repository.datasource.LocalDataSource
import com.reachout.data.repository.datasource.RemoteDataSource
import com.reachout.domain.extension.repoFlow
import com.reachout.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getItemList(number: Int) = repoFlow {
        try {
            val data = remoteDataSource.getItemList(number)
            if (data.isNotEmpty()) {
                localDataSource.addItemList(data)
            }
            AnimalDomainMapper().toDomain(localDataSource.getItemList())
        } catch (e: Exception) {
            println("Interceptor [25] : ${e.message}")
            AnimalDomainMapper().toDomain(localDataSource.getItemList())
        }
    }.flowOn(dispatcher)
}