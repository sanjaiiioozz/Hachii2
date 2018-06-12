package com.example.user.hachii.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.user.hachii.Providers.MenuProvider
import com.example.user.hachii.R
import com.example.user.hachii.SetMenu
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 */
class SetFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var setList: List<SetMenu> = listOf()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://52.221.98.249:100/Choky/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(MenuProvider::class.java).GetALlSetMenu(1)
                .enqueue(object : Callback<MutableList<SetMenu>> {
                    override fun onResponse(call: Call<MutableList<SetMenu>>?, response: Response<MutableList<SetMenu>>?) {

                        var resultData = response?.body() ?: mutableListOf()
                        setList = resultData!!
                        activity?.let {
                            lv_frag_main.adapter = SetAdapter(activity!!, setList)
                        }
                    }

                    override fun onFailure(call: Call<MutableList<SetMenu>>?, t: Throwable?) {
                        Toast.makeText(activity,
                                "Something went wrong: mainFragment,getAllMainMenu",
                                Toast.LENGTH_LONG).show()
                    }
                })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
