package com.reachout.data.repository.datasourceimpl

import com.reachout.data.api.ApiService
import com.reachout.data.model.Animal
import com.reachout.data.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getItemList(number: Int): List<Animal> {
        return apiService.getAnimalList(number)
    }
}