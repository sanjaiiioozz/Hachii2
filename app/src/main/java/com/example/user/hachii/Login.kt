package com.example.user.hachii

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_register.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        btnRegisterR.setOnClickListener {
            if (txtPassword.text.toString() == txtConfirmPassword.text.toString()) {
                if (txtUsername.text.toString() != "" && txtName.text.toString() != "" && txtPassword.text.toString() != "") {
                    val intent = Intent(this, First::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext,
                            "Plaese filled your infornation",
                            Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(applicationContext,
                        "Password mismatch",
                        Toast.LENGTH_LONG).show()
            }
        }
    }
}
