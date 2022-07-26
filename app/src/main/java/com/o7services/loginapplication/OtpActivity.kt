package com.o7services.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class OtpActivity : AppCompatActivity() {
    var email: String = ""
    lateinit var tvEmail: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        intent?.let { abc->
            if(abc.hasExtra("email"))
            email = abc.getStringExtra("email") as String

        }?:kotlin.run {  }
        tvEmail = findViewById(R.id.tvEmail)

        tvEmail.setText(email)

    }
}