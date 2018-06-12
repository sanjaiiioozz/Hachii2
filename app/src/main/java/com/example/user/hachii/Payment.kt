package com.example.user.hachii

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_payment.*

class Payment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        var intent = getIntent()
        var rx = intent.getDoubleExtra("Total",0.00)
        total.text = "Total Cost: "+rx
        paybtn.setOnClickListener{
            val intent = Intent(this, SuccesfulPayment::class.java)
            startActivity(intent)

        }
    }
}
