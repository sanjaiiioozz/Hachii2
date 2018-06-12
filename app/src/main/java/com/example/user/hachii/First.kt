package com.example.user.hachii

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class First : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        login.setOnClickListener{
            val intent = Intent(this, logi::class.java)
            startActivity(intent)
        }


        regis.setOnClickListener{

            val intent = Intent(this, Login::class.java)
            startActivity(intent)

        }

    }
}
