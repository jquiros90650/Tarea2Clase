package com.example.tarea2.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tarea2.model.Producto
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.ktx.Firebase

class ProductoDao {
    //Firebase Vars
    private var codigoUsuario: String
    private var firestore: FirebaseFirestore

    init {
        codigoUsuario = Firebase.auth.currentUser?.email.toString()
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun getAllData(): MutableLiveData<List<Producto>> {
        val listaProducto = MutableLiveData<List<Producto>>()
        firestore
            .collection("productos")
            .document(codigoUsuario)
            .collection("misProductos")
            .addSnapshotListener{ snapshot, e ->
                if(e!=null){
                    return@addSnapshotListener
                }
                if(snapshot != null){
                    val lista = ArrayList<Producto>()
                    val productos = snapshot.documents
                    productos.forEach{
                        val producto = it.toObject(Producto::class.java)
                        if(producto != null){
                            lista.add(producto)
                        }
                    }
                    listaProducto.value = lista
                }
            }
        return listaProducto
    }

    fun addProducto(producto: Producto){
        val document: DocumentReference
        if(producto.id.isEmpty()){
            //Agregar
            document = firestore
                .collection("productos")
                .document(codigoUsuario)
                .collection("misProductos")
                .document()
            producto.id = document.id
        }else{
            //Modificar
            document = firestore
                .collection("productos")
                .document(codigoUsuario)
                .collection("misProductos")
                .document(producto.id)
        }
        document.set(producto)
            .addOnCompleteListener{
                Log.d("guardarProducto","Guardado con exito")
            }
            .addOnCompleteListener{
                Log.e("guardarProducto","Error al guardar")
            }
    }



    fun eliminarProducto(producto: Producto){
        if (producto.id.isNotEmpty()){
            firestore
                .collection("ProductoNovedosos")
                .document(codigoUsuario)
                .collection("misProductos")
                .document(producto.id)
                .delete()
                .addOnCompleteListener{
                    Log.d("eliminarProducto", "Eliminar con exito")
                }
                .addOnCanceledListener{
                    Log.e("eliminarProducto","Error al Eliminar")
                }
        }
    }


}