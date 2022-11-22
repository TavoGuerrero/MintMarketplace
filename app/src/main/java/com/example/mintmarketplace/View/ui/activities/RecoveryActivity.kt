package com.example.mintmarketplace.View.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mintmarketplace.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecoveryActivity: AppCompatActivity() {

    lateinit var recoverybutton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        firebaseAuth= Firebase.auth

        recoverybutton= findViewById(R.id.recovery)
        recoverybutton.setOnClickListener {
            startActivity(Intent(this,login::class.java))
        }
    }
    private fun cambiocontrasena(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this){
                    Task-> if (Task.isSuccessful){
                        Toast.makeText(baseContext,  "Correo de cambio de contrasena enviado", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,login::class.java))
            }else{
                Toast.makeText(baseContext,  "Error, no se completo cambio", Toast.LENGTH_SHORT).show()
            }
            }

    }
}