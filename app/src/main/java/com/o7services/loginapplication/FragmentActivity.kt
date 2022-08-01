package com.o7services.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

/*
* Created on 1st August
* Covers Snackbar, alert dialog, interfaces
*/
class FragmentActivity : AppCompatActivity() {
    lateinit var btnCallFragment: Button
    lateinit var activityInterface: ActivityInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        btnCallFragment = findViewById(R.id.btnCallFragment)
        btnCallFragment.setOnClickListener {
            activityInterface.ActivityInterface()
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Title")
            alertDialog.setMessage("Alert dialog message")
            alertDialog.setPositiveButton("Positive"){_,_->
                Toast.makeText(this, " Positive clicked", Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNegativeButton("Negative"){_,_->
                Toast.makeText(this, " Negative clicked", Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNeutralButton("Neutral"){_,_->
                Toast.makeText(this, " Neutral clicked", Toast.LENGTH_SHORT).show()
            }
            alertDialog.show()

        }
    }
}