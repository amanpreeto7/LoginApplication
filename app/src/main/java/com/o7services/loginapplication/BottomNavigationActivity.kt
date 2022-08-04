package com.o7services.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var bottomMenu : BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomMenu = findViewById(R.id.bottomMenu)
        navController = findNavController(R.id.navController)
        bottomMenu.setOnItemSelectedListener { it->
            when(it.itemId){
                R.id.home->{
                    navController.navigate(R.id.navHostFirstFragment)
                    Toast.makeText(this@BottomNavigationActivity, " first clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.messages->{
                    navController.navigate(R.id.navHostSecondFragment)

                    Toast.makeText(this@BottomNavigationActivity, " second clicked", Toast.LENGTH_SHORT).show()

                }
                R.id.settings->{
                    navController.navigate(R.id.thirdFragment)

                    Toast.makeText(this@BottomNavigationActivity, " third clicked", Toast.LENGTH_SHORT).show()

                }
            }

            return@setOnItemSelectedListener true

        }
    }
}