package com.example.mintmarketplace.View.ui.activities.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Repo {
    fun getProductos(tipo:String): LiveData<MutableList<Productos>>{
        val mutableData = MutableLiveData<MutableList<Productos>>()

        val db = FirebaseFirestore.getInstance()
        db.collection("Productos").get().addOnSuccessListener {
            result ->
            val listData = mutableListOf<Productos>()
            for (document in  result){
                val imagen = document.getString("Imagen")
                val nombre = document.getString("Nombre")
                val precio = document.getString("Precio")
                val tipoProducto = document.getString("Tipo")

                if(imagen != null){
                    Log.d("TIPO",imagen)
                }
                val producto = Productos(imagen,nombre!!,precio!!,tipoProducto!!)
                if(tipo == tipoProducto){
                    listData.add(producto)
                }
            }
            mutableData.value = listData
        }
        return mutableData
    }
}