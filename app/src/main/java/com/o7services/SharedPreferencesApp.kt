package com.o7services

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.o7services.loginapplication.R
import com.o7services.loginapplication.databinding.ActivitySharedPreferencesAppBinding

class SharedPreferencesApp : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var binding: ActivitySharedPreferencesAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(
            resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if(sharedPreferences.contains("Data")){
            binding.editText.setText(sharedPreferences.getString("Data",""))
        }

        binding.button.setOnClickListener {
            if(binding.editText.text.isNullOrEmpty() == false){
                editor.putString("Data", binding.editText.text.toString())
                editor.apply()
            }else{
                Toast.makeText(this, "enter value to save", Toast.LENGTH_SHORT).show()
            }
        }

        binding.remove.setOnClickListener {
            editor.clear()
            editor.apply()
        }

    }
}