package com.example.tarea2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tarea2.data.ProductoDao
import com.example.tarea2.model.Producto
import com.example.tarea2.repository.ProductoRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository:ProductoRepository = ProductoRepository(ProductoDao())
    private val obtenerProductos:MutableLiveData<List<Producto>>

    init{

        obtenerProductos = repository.obtenerProductos
    }

    fun guardarProducto(producto:Producto){
        repository.guardarProducto(producto)
    }
    fun eliminarProducto(producto: Producto){
        repository.eliminarProducto(producto)
    }}

