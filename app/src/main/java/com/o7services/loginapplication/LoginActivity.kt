package com.o7services.loginapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged

class LoginActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var etPhone: EditText
    lateinit var btnLogin : Button
    lateinit var tvForgotPassword : TextView
    lateinit var ivNotification : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        etPhone = findViewById(R.id.etPhoneNumber)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        ivNotification = findViewById(R.id.ivNotification)
        ivNotification.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_add))
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
            System.out.println("Login clicked")
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)
           /* if(etName.text.toString().isNullOrEmpty()){
                Toast.makeText(this, resources.getString(R.string.please_enter_name), Toast.LENGTH_LONG).show()
                etName.error = resources.getString(R.string.please_enter_name)
                etName.requestFocus()
            }else if(etPassword.text.toString().isNullOrEmpty()){
                Toast.makeText(this, resources.getString(R.string.please_enter_password), Toast.LENGTH_LONG).show()
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }*/
        }

    }
}