package com.example.tarea2.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tarea2.R
import com.example.tarea2.databinding.FragmentUpdateProductoBinding
import com.example.tarea2.databinding.FragmentUpdateProductoBinding
import com.example.tarea2.model.Producto
import com.example.tarea2.viewmodel.HomeViewModel

class UpdateProductoFragment : Fragment() {

// Recuperar los elementos enviados
private val args by navArgs<UpdateProductoFragmentArgs>()

private var _binding: FragmentUpdateProductoBinding? = null
private val binding get() = _binding!!
private lateinit var homeViewModel:HomeViewModel


        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentUpdateProductoBinding.inflate(inflater,container, false)


        // carga de Producto
        binding.etNombre.setText(args.productoArg.nombre)
        binding.etCorreoProducto.setText(args.productoArg.correo)
        binding.etTelefono.setText(args.productoArg.telefono)
        binding.etWeb.setText(args.productoArg.web)

        binding.btUpdateProducto.setOnClickListener {updateProducto()}



        // Inflate the layout for this fragment
        return binding.root
        }
private fun updateProducto(){
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreoProducto.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val web = binding.etEstadoProducto.text.toString()
        if (nombre.isNotEmpty()){
        val producto = Producto(args.productoArg.id,nombre, correo, telefono,EstadoProducto)
        homeViewModel.guardarProducto(producto)
        Toast.makeText(requireContext(),getText(R.string.ms_UpdateProducto),Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updateProductoFragment_to_nav_home)
        }
        else{
        Toast.makeText(requireContext(),getString(R.string.ms_FaltaValores),Toast.LENGTH_LONG).show()
        }


        }

        }