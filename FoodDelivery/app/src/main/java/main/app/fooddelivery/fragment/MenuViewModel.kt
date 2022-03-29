package main.app.fooddelivery.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.app.fooddelivery.domain.models.ProductEntity
import main.app.fooddelivery.network.repository.ProductRepository
import timber.log.Timber

class MenuViewModel(private val productRepository: ProductRepository) : ViewModel() {
    val productList: LiveData<List<ProductEntity>> = productRepository.productList

    override fun onCleared() {
        super.onCleared()
        Timber.d("VM cleared")
    }

    fun getAllProductsList() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getAllProductsList()
        }
    }
}