package com.example.user.hachii

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.user.hachii.Providers.MenuProvider
import kotlinx.android.synthetic.main.activity_check_out.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CheckOut : AppCompatActivity() {

    companion object {
        var checkOutList: MutableList<String> = mutableListOf()
        var mainCheckOut: MutableList<MainDish> = mutableListOf()
        var sideCheckOut: MutableList<SideDish> = mutableListOf()
    }

    var temp: String = ""
    var tempMain: String = ""
    var tempSide: String = ""
    var total: Double = 0.0
    var printed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        for (x in checkOutList) {
            when (x[0]) {
                'm' -> {
                    val id = x.substring(1).toInt()
                    queryMain(id)
                }
                's' -> {
                    val id = x.substring(1).toInt()
                    querySide(id)
                }
            }
        }
        orderer.setOnClickListener {
            val intent = Intent(this, Payment::class.java)
            intent.putExtra("Total",total)
            startActivity(intent)
        }
        /*orderer.setOnClickListener {
            val intent = Intent(this, First::class.java)
            startActivity(intent)
        }*/
    }

    private fun queryMain(Id: Int): MainDish? {
        var out: MainDish? = null
        val retrofit = Retrofit.Builder()
                .baseUrl("http://52.221.98.249:100/Choky/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(MenuProvider::class.java).GetMainMenu(Id)
                .enqueue(object : Callback<MainDish> {
                    override fun onResponse(call: Call<MainDish>?, response: Response<MainDish>?) {
                        var resultData = response?.body()
                        out = resultData
                        mainCheckOut.add(out!!)
                        total += resultData!!.Price
                        if (tempMain == "") {
                            tempMain += "Main Dish:\n"
                        }
                        tempMain += "     ${resultData.NameEN} ฿${resultData.Price}\n"

                        if (mainCheckOut.size + sideCheckOut.size == checkOutList.size && !printed) {
                            temp = tempMain + "\n" + tempSide + "\nTotal: ฿${total}"
                            tv_resultCheckOut.text = temp
                            printed = true
                        }
                    }

                    override fun onFailure(call: Call<MainDish>?, t: Throwable?) {
                        Toast.makeText(applicationContext,
                                "Something went wrong: checkOut,getMainDish",
                                Toast.LENGTH_LONG).show()

                    }
                })
        return out
    }

    private fun querySide(Id: Int): SideDish? {
        var out: SideDish? = null
        val retrofit = Retrofit.Builder()
                .baseUrl("http://52.221.98.249:100/Choky/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(MenuProvider::class.java).GetSideMenu(Id)
                .enqueue(object : Callback<SideDish> {
                    override fun onResponse(call: Call<SideDish>?, response: Response<SideDish>?) {
                        var resultData = response?.body()
                        out = resultData
                        sideCheckOut.add(out!!)
                        total += resultData!!.Price
                        if (tempSide == "") {
                            tempSide += "Side Dish:\n"
                        }
                        tempSide += "     ${resultData.NameEN} ฿${resultData.Price}\n"

                        if (mainCheckOut.size + sideCheckOut.size == checkOutList.size && !printed) {
                            temp = tempMain + "\n" + tempSide + "\nTotal: ฿${total}"
                            tv_resultCheckOut.text = temp
                            printed = true
                        }
                    }

                    override fun onFailure(call: Call<SideDish>?, t: Throwable?) {
                        Toast.makeText(applicationContext,
                                "Something went wrong: checkOut,getMainDish",
                                Toast.LENGTH_LONG).show()
                    }
                })
        return out
    }
}
