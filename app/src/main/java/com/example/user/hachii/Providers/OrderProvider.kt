package com.example.user.hachii.Providers

import com.example.user.hachii.Order
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Rpani on 04-Jan-18.
 */
interface OrderProvider {

    @GET("Order")
    fun GetOrder(@Query("Id") id: Int): Call<Order>

}