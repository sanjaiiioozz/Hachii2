package com.example.user.hachii.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.user.hachii.MainDish
import com.example.user.hachii.Providers.MenuProvider
import com.example.user.hachii.R
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 */
//52.221.98.249:100/Choky/controller
class MainFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mainDishList: List<MainDish> = listOf()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://52.221.98.249:100/Choky/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(MenuProvider::class.java).GetAllMainMenu(1)
                .enqueue(object : Callback<MutableList<MainDish>> {
                    override fun onResponse(call: Call<MutableList<MainDish>>?, response: Response<MutableList<MainDish>>?) {
                        var resultData = response?.body() ?: mutableListOf()
                        mainDishList = resultData!!
                        activity?.let {
                            lv_frag_main.adapter = MainDishAdapter(activity!!, mainDishList)
                        }
                    }

                    override fun onFailure(call: Call<MutableList<MainDish>>?, t: Throwable?) {
                        Toast.makeText(activity,
                                "Something went wrong: mainFragment,getAllMainMenu" + t,
                                Toast.LENGTH_LONG).show()
                    }
                })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)
}