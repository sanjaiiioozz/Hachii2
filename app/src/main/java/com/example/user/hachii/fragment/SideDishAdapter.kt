package com.example.user.hachii.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.user.hachii.CheckOut
import com.example.user.hachii.R
import com.example.user.hachii.SideDish
import kotlinx.android.synthetic.main.card_menu_left.view.*
import kotlinx.android.synthetic.main.card_menu_right.view.*

/**
 * Created by Rpani on 04-Jan-18.
 */

class SideDishAdapter(val mCtx: Context,
                      val itemList: List<SideDish>)
    : ArrayAdapter<SideDish>(mCtx, 0, itemList) {

    override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
        var layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        var foodCounter = 0

        val imageURL = itemList[p0].Image
        if (p0 % 2 == 0) {
            var viewl: View = layoutInflater.inflate(R.layout.card_menu_left, null)
            viewl.nameInThail.text = itemList[p0].NameTH
            viewl.nameInEngl.text = itemList[p0].NameEN
            viewl.pricel.text = (itemList[p0].Price).toString()
            Glide.with(context)
                    .load(imageURL)
                    .into(viewl.food_imgl)
            viewl.foodCounterl.text = "0"
            viewl.bt_Minusl.setOnClickListener {
                if (foodCounter > 0) {
                    foodCounter--
                    // update

                    viewl.foodCounterl.text = foodCounter.toString()
                    CheckOut.checkOutList.remove("s${itemList[p0].Id}")
                }
            }
            viewl.bt_Addl.setOnClickListener {
                foodCounter++
                viewl.foodCounterl.text = foodCounter.toString()
                CheckOut.checkOutList.add("s${itemList[p0].Id}")

            }
            return viewl
        } else {
            var viewr: View = layoutInflater.inflate(R.layout.card_menu_right, null)
            viewr.nameInThair.text = itemList[p0].NameTH
            viewr.nameInEngr.text = itemList[p0].NameEN
            viewr.pricer.text = (itemList[p0].Price).toString()
            Glide.with(context)
                    .load(imageURL)
                    .into(viewr.food_imgr)
            viewr.foodCounterr.text = "0"
            viewr.bt_Minusr.setOnClickListener {
                if (foodCounter > 0) {
                    foodCounter--
                    // update
                    viewr.foodCounterr.text = foodCounter.toString()
                    CheckOut.checkOutList.remove("s${itemList[p0].Id}")
                }
            }
            viewr.bt_Addr.setOnClickListener {
                foodCounter++
                viewr.foodCounterr.text = foodCounter.toString()
                CheckOut.checkOutList.remove("s${itemList[p0].Id}")
            }
            return viewr
        }
    }
}