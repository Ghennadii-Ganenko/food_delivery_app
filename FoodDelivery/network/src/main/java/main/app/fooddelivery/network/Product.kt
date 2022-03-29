package main.app.fooddelivery.network

import com.google.gson.annotations.SerializedName
import main.app.fooddelivery.domain.network.Product

class Product : Product {
    @SerializedName("name")
    override val name: String = ""

    @SerializedName("price")
    override val price: Double = 0.0

    @SerializedName("description")
    override val description: String = ""

//    @SerializedName("img")
//    override val img: String = ""
}