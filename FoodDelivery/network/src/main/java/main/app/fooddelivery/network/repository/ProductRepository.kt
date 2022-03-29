package main.app.fooddelivery.network.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import main.app.fooddelivery.domain.mapper.ProductMapper
import main.app.fooddelivery.domain.models.ProductEntity
import main.app.fooddelivery.network.ProductList
import main.app.fooddelivery.network.common.Common
import main.app.fooddelivery.network.interfaces.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private lateinit var mService: RetrofitService
    val productList = MutableLiveData<List<ProductEntity>>()

    fun getAllProductsList() {
        mService = Common.retrofitService
        val productMapper = ProductMapper()
        mService.getProducts().enqueue(object : Callback<ProductList> {
            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                Log.e("IsFailResponse", t.message.toString())
            }

            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                if (response.isSuccessful) {
                    productList.postValue(productMapper.map(response.body()!!.data!!.toList()))
                } else {
                    Log.e("Critical", response.toString())
                }
            }
        })
    }
}