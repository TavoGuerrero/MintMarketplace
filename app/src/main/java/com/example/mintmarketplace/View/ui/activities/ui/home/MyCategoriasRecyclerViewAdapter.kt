package com.example.mintmarketplace.View.ui.activities.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mintmarketplace.View.ui.activities.HomeActivity
import com.example.mintmarketplace.View.ui.activities.InicioActivity
import com.example.mintmarketplace.View.ui.activities.ProductosActivity
import com.example.mintmarketplace.View.ui.activities.ui.home.placeholder.PlaceholderContent.PlaceholderItem
import com.example.mintmarketplace.databinding.FragmentCategoriasBinding
const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
class MyCategoriasRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val activity: InicioActivity
) : RecyclerView.Adapter<MyCategoriasRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCategoriasBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.title
        holder.contentView.text = item.details
        holder.categoriaImg.setImageResource(item.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(activity, ProductosActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, item.title)
            }
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCategoriasBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.categoriaNombre
        val contentView: TextView = binding.content
        val categoriaImg : ImageView = binding.categoriaImg

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}