package com.o7services.loginapplication

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class PermissionActivity : AppCompatActivity() {
    lateinit var  btnGetPermission: Button
    lateinit var  image: ImageView
    var getPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        isGranted->
        if(isGranted) {
            Toast.makeText(this, " Granted", Toast.LENGTH_SHORT).show()
            getImage.launch("image/*")

        }else{
            Toast.makeText(this, "Not Granted", Toast.LENGTH_SHORT).show()

        }
    }

    var getImage = registerForActivityResult(
        ActivityResultContracts.GetContent()){
        System.out.println("it $it")
        image.setImageURI(it)
    }

    var getMulPermissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()){
            isGranted->
//        if(isGranted)(
//                Toast.makeText(this, " Granted", Toast.LENGTH_SHORT).show()
//                )else{
//            Toast.makeText(this, "Not Granted", Toast.LENGTH_SHORT).show()
//
//        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        btnGetPermission = findViewById(R.id.btnGetPermission)
        image = findViewById(R.id.image)
        btnGetPermission.setOnClickListener {

            getMulPermissions.launch(arrayOf(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE))
            if(ContextCompat.checkSelfPermission(this,
                    READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            {
                getImage.launch("image/*")
                Toast.makeText(this, " Granted ", Toast.LENGTH_SHORT).show()}
            else
                getPermission.launch(READ_EXTERNAL_STORAGE)
        }
    }
}