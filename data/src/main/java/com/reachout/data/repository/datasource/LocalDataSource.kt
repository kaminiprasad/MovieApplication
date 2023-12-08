package com.reachout.data.repository.datasource

import com.reachout.data.model.Animal

interface LocalDataSource {
    suspend fun getItemList(): List<Animal>
    suspend fun addItemList(items: List<Animal>)
}