package com.o7services.loginapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.o7services.loginapplication.databinding.LayoutDialogBinding

class AlertDialogActivity : AppCompatActivity() {
    lateinit var fab: FloatingActionButton
    lateinit var btn: Button
    lateinit var tvName: TextView
    var enteredText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        fab = findViewById(R.id.fab)
        btn = findViewById(R.id.btn)
        tvName = findViewById(R.id.tvName)
        btn.setOnClickListener {
            val dialogBinding = LayoutDialogBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(dialogBinding.root)
            dialog.show()

            if(enteredText.isNullOrEmpty() == false){
                dialogBinding.etName.setText(enteredText)
            }

            dialogBinding.btnOk.setOnClickListener {
                if(dialogBinding.etName.text.toString().isNullOrEmpty()){
                    Toast.makeText(this@AlertDialogActivity, "Enter name", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                enteredText = dialogBinding.etName.text.toString()
                tvName.setText(enteredText)
                dialog.dismiss()
            }
        }
        fab.setOnClickListener {
            Log.e("TAG", " clicked")
            var arrayList = arrayOf("q", "w","e")
           var alertDialog =  AlertDialog.Builder(this).apply {
                setTitle("List dialog")
              // setMessage("Dialog with message and list")
               setItems(arrayList) { _, item ->

                   Toast.makeText(this@AlertDialogActivity, "selected Item ${arrayList[item]}", Toast.LENGTH_LONG).show()

               }
               setPositiveButton("OK"){_,_->

               }
            }
               alertDialog.show()
        }
    }
}