package com.example.mintmarketplace.View.ui.activities.ui.productos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mintmarketplace.View.ui.activities.domain.Productos
import com.example.mintmarketplace.View.ui.activities.domain.Repo

class ProductosViewModel : ViewModel() {
    val repo = Repo()
    fun fetchProductosData( tipo: String):LiveData<MutableList<Productos>>{
        val mutableData = MutableLiveData<MutableList<Productos>>()
        repo.getProductos(tipo).observeForever {
            mutableData.value = it
        }
        return mutableData
    }
}