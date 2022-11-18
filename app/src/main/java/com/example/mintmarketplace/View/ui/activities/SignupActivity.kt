package com.example.mintmarketplace.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mintmarketplace.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity: AppCompatActivity() {
    lateinit var btnregister:Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        firebaseAuth= Firebase.auth
        btnregister=findViewById(R.id.register)
        btnregister.setOnClickListener {
            crearcuenta(correo.text.toString(),contrasena.text.toString())
            startActivity(Intent(this,login::class.java))
        }
        val correo=findViewById<EditText>(R.id.correoregistro)
        val contrasena=findViewById<EditText>(R.id.contrasenaregistro)
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

