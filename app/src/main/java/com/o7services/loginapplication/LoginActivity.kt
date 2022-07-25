package com.o7services.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class LoginActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var etPhone: EditText
    lateinit var btnLogin : Button
    lateinit var tvForgotPassword : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        etPhone = findViewById(R.id.etPhoneNumber)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)

        tvForgotPassword.setOnClickListener {
            var intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        etPhone.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <10){
                etPhone.error = resources.getString(R.string.enter_phone)
            }
        }
        btnLogin.setOnClickListener {
            if(etName.text.toString().isNullOrEmpty()){
                Toast.makeText(this, resources.getString(R.string.please_enter_name), Toast.LENGTH_LONG).show()
                etName.error = resources.getString(R.string.please_enter_name)
                etName.requestFocus()
            }else if(etPassword.text.toString().isNullOrEmpty()){
                Toast.makeText(this, resources.getString(R.string.please_enter_password), Toast.LENGTH_LONG).show()
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
        }

    }
}