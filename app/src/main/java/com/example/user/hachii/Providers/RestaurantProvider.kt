package com.example.user.hachii.Providers

/**
 * Created by Rpani on 04-Jan-18.
 */
import com.example.user.hachii.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantProvider {

    @GET("Restaurant")
    fun GetAllRestaurant(): Call<Restaurant>
}