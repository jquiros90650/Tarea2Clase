package com.example.tarea2.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tarea2.R
import com.example.tarea2.databinding.FragmentGuardarProductoBinding
import com.example.tarea2.model.Producto
import com.example.tarea2.utilities.ImageUtilities
import com.example.tarea2.viewmodel.HomeViewModel


class GuardarProductoFragment : Fragment() {
    var _binding: FragmentGuardarProductoBinding? = null
    val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var imagenUtiles: ImageUtilities
    private lateinit var tomarFotoActivity: ActivityResultLauncher<Intent>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentGuardarProductoBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener { agregarProducto() }

        //Fotos
        tomarFotoActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->
            if(result.resultCode == Activity.RESULT_OK){
                imagenUtiles.actualizaFoto()
            }
        }

        imagenUtiles = ImageUtilities(requireContext(), binding.btPhoto, binding.btRotaL, binding.btRotaR, binding.imagen, tomarFotoActivity)



        // Inflate the layout for this fragment
        return binding.root
    }

    private fun agregarProducto() {
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreo.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val estado = binding.etEstado.text.toString()

        if (nombre.isNotEmpty()) {
            val producto = Producto("", nombre, correo, telefono, estado)
            homeViewModel.guardarProducto(producto)
            Toast.makeText(requireContext(), getText(R.string.ms_AddProducto), Toast.LENGTH_LONG)
                .show()
            findNavController().navigate(R.id.action_addProductoFragment_to_nav_home)
        } else {
            Toast.makeText(requireContext(), getText(R.string.ms_FaltaValores), Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}