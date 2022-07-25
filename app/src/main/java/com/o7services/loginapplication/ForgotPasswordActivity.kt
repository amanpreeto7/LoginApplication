package com.o7services.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var btnForgetPassword: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        etEmail = findViewById(R.id.etEmail)
        btnForgetPassword = findViewById(R.id.btnForget)

        btnForgetPassword.setOnClickListener {
            if(etEmail.text.toString().isNullOrEmpty()){
                etEmail.requestFocus()
                Toast.makeText(this, resources.getString(R.string.enter_email), Toast.LENGTH_SHORT).show()
            }else {
                var intent = Intent(this, OtpActivity::class.java)
                intent.putExtra("emailId", etEmail.text.toString())
                startActivity(intent)
            }
        }
    }
}