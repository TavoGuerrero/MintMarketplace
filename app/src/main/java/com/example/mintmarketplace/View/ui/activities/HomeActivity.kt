package com.example.mintmarketplace.View.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mintmarketplace.R

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onBackPressed() {
        return
    }
}