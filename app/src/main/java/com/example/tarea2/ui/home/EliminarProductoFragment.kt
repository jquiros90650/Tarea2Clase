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
import com.example.tarea2.databinding.FragmentEliminarProductoBinding
import com.example.tarea2.model.Producto
import com.example.tarea2.viewmodel.HomeViewModel


class EliminarProductoFragment : Fragment() {


// Recuperar los elementos enviados
    val args by navArgs<EliminarProductoFragmentArgs>()
    var _binding: FragmentEliminarProductoBinding? = null
    val binding get() = _binding!!
    lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentEliminarProductoBinding.inflate(inflater, container, false)


        // carga de Producto
        binding.etNombre.setText(args.productoArg.nombre)
        binding.etCorreo.setText(args.productoArg.correo)
        binding.etTelefono.setText(args.productoArg.telefono)
        binding.etEstado.setText(args.productoArg.web)

        binding.btDelete.setOnClickListener { eliminarProducto() }

        // Inflate the layout for this fragment

        return binding.root
    }


    private fun eliminarProducto() {
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreo.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val estadoproducto = binding.etEstado.text.toString()
        if (nombre.isNotEmpty()) {
            val producto = Producto(args.productoArg.id, nombre, correo, telefono, estadoproducto)
            homeViewModel.eliminarProducto(producto)
            Toast.makeText(
                requireContext(),
                getText(R.string.ms_EliminarProducto),
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_deleteProductoFragment_to_nav_home)
        } else {
            Toast.makeText(requireContext(), getString(R.string.ms_FaltaValores), Toast.LENGTH_LONG)
                .show()
        }


    }

