package com.example.tarea2.model

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Email
import kotlinx.parcelize.Parcelize


@Parcelize
data class Producto (
    var id: String,
    val nombre: String,
    val email: String,
    val costo: String,
    val estado: String?

): Parcelable {

    constructor():
                this("","","","","")
}