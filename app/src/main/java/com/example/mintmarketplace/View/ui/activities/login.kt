package com.example.mintmarketplace.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mintmarketplace.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class login:AppCompatActivity() {

    lateinit var signuptext: TextView
    lateinit var loginbutton: Button
    lateinit var recoverytext: TextView
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email: EditText = findViewById(R.id.editTextTextEmailAddress)
        val password: EditText = findViewById(R.id.editTextTextPassword)
        firebaseAuth = Firebase.auth


        signuptext = findViewById(R.id.signup)
        loginbutton = findViewById(R.id.ingresarBoton)
        recoverytext = findViewById(R.id.recovery)

        signuptext.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
        recoverytext.setOnClickListener {
            startActivity(Intent(this, RecoveryActivity::class.java))
        }
        loginbutton.setOnClickListener {
            login(email.text.toString(),password.text.toString())
        }
    }

    private fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { Task ->
                if (Task.isSuccessful) {
                    val i = Intent(this, InicioActivity::class.java)
                    startActivity(i)
                    finish()
                } else {
                    Toast.makeText(baseContext, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }
    }

}