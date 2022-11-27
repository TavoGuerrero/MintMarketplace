package com.example.mintmarketplace.View.ui.activities.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mintmarketplace.R
import com.example.mintmarketplace.View.ui.activities.HomeActivity
import com.example.mintmarketplace.View.ui.activities.InicioActivity
import com.example.mintmarketplace.View.ui.activities.ui.home.placeholder.PlaceholderContent

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categorias_list, container, false)
        val categoriasList = view.findViewById<RecyclerView>(R.id.list)
        categoriasList.layoutManager = LinearLayoutManager(context)
        categoriasList.adapter = MyCategoriasRecyclerViewAdapter(PlaceholderContent.ITEMS,
            this.activity as InicioActivity
        )

        return view
    }
}