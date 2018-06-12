package com.example.user.hachii.Providers

/**
 * Created by Rpani on 04-Jan-18.
 */
import com.example.user.hachii.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserProvider {

    @GET("User")
    fun Login(@Query("username") username: String, @Query("password") password: String): Call<User>

    @GET("User")
    fun Register(@Query("username") username: String, @Query("password") password: String, @Query("name") name: String): Call<Boolean>
}