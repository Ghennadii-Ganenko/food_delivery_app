package main.app.fooddelivery.domain.mapper

import main.app.fooddelivery.domain.models.ProductEntity
import main.app.fooddelivery.domain.network.Product

class ProductMapper : Mapper<List<Product>, List<ProductEntity>> {
    override fun map(input: List<Product>) = input.map { mapSingle(it) }

    private fun mapSingle(input: Product) = ProductEntity(
        name = input.name,
        price = input.price,
        description = input.description,
//        img = input.img,
    )
}