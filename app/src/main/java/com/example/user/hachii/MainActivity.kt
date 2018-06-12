package com.example.user.hachii

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.user.hachii.fragment.MainFragment
import com.example.user.hachii.fragment.SideFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.*

class MainActivity : AppCompatActivity() {
    companion object {
//        var checkOutList: MutableList<String> = mutableListOf()
    }

    var pagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        pagerAdapter = PagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragment(MainFragment(), "Main Dish")
        pagerAdapter!!.addFragment(SideFragment(), "Side Order")
//        pagerAdapter!!.addFragment(SetFragment(), "Set Menu")

        costomViewPager.adapter = pagerAdapter
        customTabLayout.setupWithViewPager(costomViewPager)

        tocart.setOnClickListener {
            val intent = Intent(this, CheckOut::class.java)
            startActivity(intent)
        }
    }
}
