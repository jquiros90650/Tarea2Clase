package com.example.tarea2.adapater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.databinding.ProductoFilaBinding
import com.example.tarea2.model.Producto
import com.example.tarea2.ui.home.HomeFragmentDirections
import java.util.Collections.emptyList


class ProductoAdapter : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

        //Lista de Producto
        private var listaProductos = emptyList<Producto>()

        fun setProducto(producto: List<Producto>){
            listaProductos = producto
            notifyDataSetChanged()
        }

        inner class ProductoViewHolder(private val itemBinding: ProductoFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {
            fun dibuja(producto: Producto) {
                itemBinding.tvNombre.text = producto.nombre
                itemBinding.tvCorreo.text = producto.email
                itemBinding.tvCosto.text = producto.costo
                itemBinding.tvEstado.text = producto.estado
                        // Evento enviar Update
                itemBinding.vistaFila.setOnClickListener {
                            val accion =
                                HomeFragmentDirections.actionNavHomeToUpdateProductoFragment(producto)
                            itemView.findNavController().navigate(accion)
                        }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
            val itemBinding = ProductoFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ProductoViewHolder(itemBinding)
        }

        override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
            val producto = listaProductos[position]
            holder.dibuja(producto)
        }

        override fun getItemCount(): Int {
            return listaProductos.size
        }
    }


