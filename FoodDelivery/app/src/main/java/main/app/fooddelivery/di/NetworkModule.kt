package main.app.fooddelivery.di

import main.app.fooddelivery.network.repository.ProductRepository
import org.koin.dsl.module

val networkModule = module {
    single {
        ProductRepository()
    }
}