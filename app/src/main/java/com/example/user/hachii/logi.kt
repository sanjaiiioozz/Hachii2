package com.example.user.hachii

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class logi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logi.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
