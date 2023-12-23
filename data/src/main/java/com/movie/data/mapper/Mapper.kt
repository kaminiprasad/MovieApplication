package com.movie.data.mapper

interface Mapper<I, O> {
    fun map(data: I): O
}

interface ListMapper<I, O> : Mapper<List<I>, List<O>>
