package com.reachout.data.repository.datasourceimpl

import com.reachout.data.db.Dao
import com.reachout.data.model.Animal
import com.reachout.data.repository.datasource.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val zooDao: Dao
) : LocalDataSource {

    override suspend fun getItemList(): List<Animal> {
        return zooDao.getAnimalList()
    }

    override suspend fun addItemList(items: List<Animal>) {
        zooDao.addAnimalList(items)
    }
}