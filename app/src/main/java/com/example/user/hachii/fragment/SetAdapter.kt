package com.example.user.hachii.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.user.hachii.R
import com.example.user.hachii.SetMenu
import kotlinx.android.synthetic.main.card_menu_left.view.*
import kotlinx.android.synthetic.main.card_menu_right.view.*

/**
 * Created by Rpani on 05-Jan-18.
 */
class SetAdapter(val mCtx: Context,
                 val itemList: List<SetMenu>)
    : ArrayAdapter<SetMenu>(mCtx, 0, itemList) {

    override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
        var layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)


        val imageURL = itemList[p0].Image
        if (p0 % 2 == 0) {
            var viewl: View = layoutInflater.inflate(R.layout.card_menu_left, null)
            viewl.nameInThail.text = itemList[p0].NameTH
            viewl.nameInEngl.text = itemList[p0].NameEN
            viewl.pricel.text = (itemList[p0].Price).toString()
            Glide.with(context)
                    .load(imageURL)
                    .into(viewl.food_imgl)
            return viewl
        } else {
            var viewr: View = layoutInflater.inflate(R.layout.card_menu_right, null)
            viewr.nameInThair.text = itemList[p0].NameTH
            viewr.nameInEngr.text = itemList[p0].NameEN
            viewr.pricer.text = (itemList[p0].Price).toString()
            Glide.with(context)
                    .load(imageURL)
                    .into(viewr.food_imgr)
            return viewr
        }
    }
}