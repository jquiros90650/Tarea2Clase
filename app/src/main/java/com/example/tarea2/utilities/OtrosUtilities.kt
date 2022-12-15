package com.example.tarea2.utilities

import java.text.SimpleDateFormat
import java.util.*

class OtrosUtilities {
    companion object{
        fun getTempFile(prefijo:String):String{
            val nombre = SimpleDateFormat("yyyyMMdd-HHmmSS", Locale.getDefault()).format(Date())
            return prefijo+nombre
        }
    }
}