package main.app.fooddelivery.network

import com.google.gson.annotations.SerializedName

class ProductList {
    @SerializedName("data")
    var data: List<Product>? = null
}