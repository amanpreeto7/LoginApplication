package com.o7services.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.o7services.loginapplication.databinding.ActivityMainBinding
import com.o7services.loginapplication.databinding.ActivityMaterialLayoutBinding

class MaterialLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityMaterialLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEmail.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)>3){
                binding.tilEmail.error = resources.getString(R.string.enter_email)
            }else{
                binding.tilEmail.error = null
            }
        }
    }
}