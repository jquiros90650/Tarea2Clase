package com.example.tarea2.repository

import androidx.lifecycle.MutableLiveData
import com.example.tarea2.data.ProductoDao
import com.example.tarea2.model.Producto

class ProductoRepository(private val productoDao : ProductoDao) {

    fun addProducto(producto: Producto){
        productoDao.addProducto(producto)
    }

    val getAllData: MutableLiveData<List<Producto>> = productoDao.getAllData()
}