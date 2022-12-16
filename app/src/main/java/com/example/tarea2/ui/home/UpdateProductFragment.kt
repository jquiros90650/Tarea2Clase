package com.example.tarea2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tarea2.R
import com.example.tarea2.databinding.FragmentUpdateProductoBinding
import com.example.tarea2.model.Producto
import com.example.tarea2.viewmodel.HomeViewModel


class UpdateProductoFragment : Fragment() {

// Recuperar los elementos enviados
    private   val args by navArgs<UpdateProductoFragmentArgs>()

    private   var _binding: FragmentUpdateProductoBinding? = null
    private   val binding get() = _binding!!
    private  lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentUpdateProductoBinding.inflate(inflater, container, false)


        // carga de Producto
        binding.etNombre.setText(args.productoArgs.nombre)
        binding.etCorreo.setText(args.productoArgs.email)
        binding.etCosto2.setText(args.productoArgs.costo)
        binding.etEstado.setText(args.productoArgs.estado)

        binding.btUpdate.setOnClickListener { updateProducto() }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun updateProducto() {
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreo.text.toString()
        val costo = binding.etCosto2.text.toString()
        val estadoProducto = binding.etEstado.text.toString()
        if (nombre.isNotEmpty()) {
            val producto = Producto(args.productoArgs.id, nombre, correo, costo, estadoProducto)
            homeViewModel.guardarProducto(producto)
            Toast.makeText(requireContext(), getText(R.string.ms_UpdateProducto), Toast.LENGTH_LONG)
                .show()
            findNavController().navigate(R.id.action_UpdateProductoFragment_to_nav_home)
        } else {
            Toast.makeText(requireContext(), getString(R.string.ms_FaltaValores), Toast.LENGTH_LONG)
                .show()
        }


    }

}





