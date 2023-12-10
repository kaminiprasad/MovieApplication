package com.reachout.data.mapper

interface DataMapper<in I, out O> {
    fun map(input: I): O
}