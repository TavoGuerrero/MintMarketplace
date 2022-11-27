package com.example.mintmarketplace.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mintmarketplace.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity: AppCompatActivity() {
    lateinit var bottomregister:Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val correo=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val contrasena=findViewById<EditText>(R.id.editTextTextPassword)

        firebaseAuth= Firebase.auth
        bottomregister=findViewById(R.id.register)
        bottomregister.setOnClickListener {
            crearcuenta(correo.text.toString(),contrasena.text.toString())
            startActivity(Intent(this,login::class.java))
        }

    }

    private fun crearcuenta(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                Task-> if (Task.isSuccessful){
                    startActivity(Intent(this,HomeActivity::class.java))
            }
            }
    }
}

