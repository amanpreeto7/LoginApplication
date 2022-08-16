package com.o7services.loginapplication.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.o7services.loginapplication.R

class RoomActivity : AppCompatActivity() {
    public lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        navController = findNavController(R.id.navController)
    }
}