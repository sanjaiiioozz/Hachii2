package com.example.user.hachii

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_succesful_payment.*

class SuccesfulPayment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_succesful_payment)
        tomain.setOnClickListener{
            val intent = Intent(this, First::class.java)
            startActivity(intent)

        }
    }
}
