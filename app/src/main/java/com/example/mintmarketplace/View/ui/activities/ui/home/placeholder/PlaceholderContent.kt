package com.example.mintmarketplace.View.ui.activities.ui.home.placeholder

import com.example.mintmarketplace.R
import java.util.ArrayList
import java.util.HashMap

object PlaceholderContent {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        val electronicos = PlaceholderItem(
            "0", "Electronicos", "Dispositivos electronicos para tu vida y tu trabajo",
            R.drawable.electronicos,
        )
        addItem(electronicos);

        val ropa =PlaceholderItem(
            "1", "Ropa", "Ropa de todas las marcas para tu trabajo y tu dia a dia",
            R.drawable.ropa,
        )
        addItem(ropa)

        val muebles =PlaceholderItem(
            "2", "Muebles", "Mobiliario para tu hogar y tu oficina",
            R.drawable.muebles,
        )
        addItem(muebles)

        val deportes = PlaceholderItem(
            "3", "Deportes", "Articulos para tu deporte favorito",
            R.drawable.deportes,
        )
        addItem(deportes)
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    data class PlaceholderItem(val id: String, val title: String, val details: String, val image: Int) {
        override fun toString(): String = title
    }
}
