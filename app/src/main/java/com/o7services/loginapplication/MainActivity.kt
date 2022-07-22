package com.o7services.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnLogin: Button
    lateinit var ivAdd: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)
        ivAdd = findViewById(R.id.ivAdd)

        ivAdd.setOnClickListener {
            System.out.println("Image Clicked")
        }

        btnLogin.setOnClickListener {
            System.out.println("Clicked")
            var name = etName.text.toString()
            var password = etPassword.text.toString()
            System.out.println("name $name")
            if(name.isNullOrEmpty()){
                etName.error = resources.getString(R.string.please_enter_name)
                etName.requestFocus()
            }else if(password.isNullOrEmpty()){
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }else{
                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
            }

        }

    }
}