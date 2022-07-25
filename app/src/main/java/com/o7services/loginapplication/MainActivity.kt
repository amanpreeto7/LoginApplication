package com.o7services.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnLogin: Button
    lateinit var ivNotification: ImageView
    lateinit var rgGender: RadioGroup
    lateinit var rbHe: RadioButton
    lateinit var rbShe: RadioButton
    lateinit var rbOther: RadioButton
    lateinit var etOtherName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)
        ivNotification = findViewById(R.id.ivNotification)
        etOtherName = findViewById(R.id.etOtherName)

        etPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                etPassword.error = resources.getString(R.string.please_enter_password)
            }else{
                etPassword.error = null
            }
        }

        //textview forget password started 25th July, 2022

        tvForgotPassword.setOnClickListener {
            var intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        //textview forget password ended

        //radio group and button started 23 July, 2022
        rbHe = findViewById(R.id.rbHe)
        rbShe = findViewById(R.id.rbShe)
        rbOther = findViewById(R.id.rbOther)
        rgGender = findViewById(R.id.rgGender)

        rgGender.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.rbOther->{
                    Toast.makeText(this, resources.getString(R.string.others), Toast.LENGTH_LONG).show()
                    etOtherName.visibility = View.VISIBLE
                }
                else->{
                    etOtherName.visibility = View.INVISIBLE
                }
            }
        }
        //handle individual radio button clicks
      /*  rbOther.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                etOtherName.visibility = View.VISIBLE
            }else{
                etOtherName.visibility = View.INVISIBLE
            }
        }*/

        //radio group and button code ended

        ivNotification.setOnClickListener {
            Toast.makeText(this, resources.getString(R.string.notification_clicked), Toast.LENGTH_LONG).show()
        }
        btnLogin.setOnClickListener {
            //to clear the text
            etName.text.clear()

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
            }else if(password.length<6){
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
            else{
                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
                var intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

    }
}