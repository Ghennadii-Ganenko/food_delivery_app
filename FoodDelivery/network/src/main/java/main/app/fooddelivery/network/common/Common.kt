package main.app.fooddelivery.network.common

import main.app.fooddelivery.network.client.RetrofitClient
import main.app.fooddelivery.network.interfaces.RetrofitService

object Common {
    private const val BASE_URL = "https://widlestudio.com/multi-restaurants-app/api/"
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}