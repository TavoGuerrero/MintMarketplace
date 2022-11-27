package com.example.mintmarketplace.View.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mintmarketplace.R

import com.example.mintmarketplace.View.ui.activities.ui.productos.ProductosFragment

class ProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProductosFragment.newInstance())
                .commitNow()
        }
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}