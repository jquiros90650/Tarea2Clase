package com.example.tarea2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Producto (
    var id: String,
    val nombre: String,
    val vendedor: String,
    val precio: String,
    val descripcion: String,
    val telefono: String,
    val correo: String?

): Parcelable {

    constructor():
                this("","","","","","","")
}