package com.reachout.data.repository.datasource

import com.reachout.data.model.Animal

interface RemoteDataSource {
    suspend fun getItemList(number: Int): List<Animal>
}