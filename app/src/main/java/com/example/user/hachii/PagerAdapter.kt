package com.example.user.hachii

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by User on 3/1/2561.
 */
class PagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm){

    var mFm = fm
    var mFragmentItem:ArrayList<Fragment> = ArrayList()
    var mFragmentTitles:ArrayList<String> = ArrayList()


    fun addFragment(fragmentItem:Fragment,fragmentTitle:String){
        mFragmentTitles.add(fragmentTitle)
        mFragmentItem.add(fragmentItem)

    }

    override fun getItem(position: Int): Fragment {
        return mFragmentItem[position]
    }

    override fun getCount(): Int {
        return mFragmentItem.size
    }
    override fun getPageTitle(position: Int): CharSequence {

        return mFragmentTitles[position]

    }
}