package com.example.tarea2.repository

import androidx.lifecycle.MutableLiveData
import com.example.tarea2.data.ProductoDao
import com.example.tarea2.model.Producto


class ProductoRepository(private val productoDao: ProductoDao) {
    fun guardarProducto(producto: Producto) {
        productoDao.guardarProducto(producto)
    }
    fun eliminarProducto(producto: Producto){
        productoDao.eliminarProducto(producto)
    }




    val obtenerProductos: MutableLiveData<List<Producto>> = productoDao.getProductos()
}