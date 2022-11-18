package com.example.mintmarketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.mintmarketplace.View.ui.activities.login
import com.example.mintmarketplace.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AnimationView.setAnimation(R.raw.animacion)
        binding.AnimationView.playAnimation()

        handler=Handler(Looper.myLooper()!!)

        handler.postDelayed({
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        },400)

    }
}