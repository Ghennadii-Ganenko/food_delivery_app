package main.app.fooddelivery.di

import main.app.fooddelivery.viewmodel.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MenuViewModel> {
        MenuViewModel(
            productRepository = get()
        )
    }
}