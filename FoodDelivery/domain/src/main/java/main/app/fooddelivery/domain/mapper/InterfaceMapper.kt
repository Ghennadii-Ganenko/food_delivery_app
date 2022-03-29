package main.app.fooddelivery.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}