package com.example.mintmarketplace.View.ui.activities.ui.productos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mintmarketplace.R
import com.example.mintmarketplace.View.ui.activities.InicioActivity
import com.example.mintmarketplace.View.ui.activities.domain.Productos
import com.example.mintmarketplace.View.ui.activities.ui.home.EXTRA_MESSAGE
import com.example.mintmarketplace.View.ui.activities.ui.home.MyCategoriasRecyclerViewAdapter
import com.example.mintmarketplace.View.ui.activities.ui.home.placeholder.PlaceholderContent

class ProductosFragment : Fragment() {
    lateinit var adapter: ProductosRecyclerViewAdapter

    companion object {
        fun newInstance() = ProductosFragment()
    }

    private lateinit var viewModel: ProductosViewModel
    private lateinit var productosLista : List<Productos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductosViewModel::class.java)
        // TODO: Use the ViewModel
        val message = activity?.intent?.getStringExtra(EXTRA_MESSAGE)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.productos_fragment, container, false)
        val tipo = activity?.intent?.getStringExtra(EXTRA_MESSAGE)
        val categoriasList = view.findViewById<RecyclerView>(R.id.productosList)
        productosLista = listOf<Productos>()
        adapter = ProductosRecyclerViewAdapter(
            productosLista,
        )
        categoriasList.layoutManager = LinearLayoutManager(context)
        categoriasList.adapter = adapter
        observeData(tipo!!)
        return view
    }

    fun observeData(tipo: String){
        viewModel.fetchProductosData(tipo).observe(viewLifecycleOwner, {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}