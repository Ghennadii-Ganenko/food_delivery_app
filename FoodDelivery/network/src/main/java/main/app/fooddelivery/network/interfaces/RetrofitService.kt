package main.app.fooddelivery.network.interfaces

import main.app.fooddelivery.network.ProductList
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("foods")
    fun getProducts(): Call<ProductList>
}