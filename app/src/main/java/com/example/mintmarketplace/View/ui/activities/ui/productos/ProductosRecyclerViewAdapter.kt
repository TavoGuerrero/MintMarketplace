package com.example.mintmarketplace.View.ui.activities.ui.productos

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mintmarketplace.R
import com.example.mintmarketplace.View.ui.activities.InicioActivity
import com.example.mintmarketplace.View.ui.activities.ProductosActivity
import com.example.mintmarketplace.View.ui.activities.domain.Productos
import com.example.mintmarketplace.View.ui.activities.ui.home.EXTRA_MESSAGE
import com.example.mintmarketplace.View.ui.activities.ui.home.placeholder.PlaceholderContent
import com.example.mintmarketplace.databinding.FragmentCategoriasBinding
import com.example.mintmarketplace.databinding.ProductosItemBinding

class ProductosRecyclerViewAdapter(
    private var values: List<Productos>
) : RecyclerView.Adapter<ProductosRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ProductosItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.Nombre
        holder.contentView.text = item.Precio
        if(item.Imagen != null){
            holder.categoriaImg.load(item.Imagen){
                crossfade(true)
                placeholder(R.drawable.deportes)
            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ProductosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.categoriaNombre
        val contentView: TextView = binding.content
        val categoriaImg : ImageView = binding.categoriaImg

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    fun setListData(data:MutableList<Productos>){
        values = data
    }
}