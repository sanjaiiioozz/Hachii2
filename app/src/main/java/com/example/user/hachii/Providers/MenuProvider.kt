package com.example.user.hachii.Providers

/**
 * Created by Rpani on 04-Jan-18.
 */
import com.example.user.hachii.Drink
import com.example.user.hachii.MainDish
import com.example.user.hachii.SetMenu
import com.example.user.hachii.SideDish
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MenuProvider {

    @GET("Menu/GetMainMenu")
    fun GetMainMenu(@Query("Id") Id: Int): Call<MainDish>

    @GET("Menu/GetSideMenu")
    fun GetSideMenu(@Query("Id") Id: Int): Call<SideDish>

    @GET("Menu/GetDrink")
    fun GetDrink(@Query("Id") Id: Int): Call<Drink>

    @GET("Menu/GetSetMenu")
    fun GetSetMenu(@Query("Id") Id: Int): Call<SetMenu>

    @GET("Menu/GetAllMainMenu")
    fun GetAllMainMenu(@Query("RestaurantId") RestaurantId: Int): Call<MutableList<MainDish>>

    @GET("Menu/GetAllSideMenu")
    fun GetAllSideMenu(@Query("RestaurantId") RestaurantId: Int): Call<MutableList<SideDish>>

    @GET("Menu/GetAllSetMenu")
    fun GetALlSetMenu(@Query("RestaurantId") RestaurantId: Int): Call<MutableList<SetMenu>>

    @GET("Menu/GetAllDrink")
    fun GetAllDrink(@Query("RestaurantId") RestaurantId: Int): Call<MutableList<Drink>>
}