package com.example.tarea2.ui.home

import androidx.navigation.fragment.findNavController
import com.example.tarea2.databinding.FragmentGuardarProductoBinding


class guardarProductoFragment : Fragment() {
private var _binding: FragmentGuardarProductoBinding? = null
private val binding get() = _binding!!
private lateinit var homeViewModel: HomeViewModel


        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentAddProductoBinding.inflate(inflater,container,false)

        binding.btAgregar.setOnClickListener{agregarProducto()}


        // Inflate the layout for this fragment
        return binding.root
        }

private fun agregarProducto(){
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreo.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val web = binding.etEstado.text.toString()

        if(nombre.isNotEmpty()){
        val producto = Producto("",nombre,correo, telefono,estado)
        homeViewModel.guardarProducto(producto)
        Toast.makeText(requireContext(),getText(R.string.ms_AddProducto), Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_addProductoFragment_to_nav_home)
        }
        else{
        Toast.makeText(requireContext(),getText(R.string.ms_FaltaValores),Toast.LENGTH_LONG).show()
        }
        }

        override fun onDestroy() {
        super.onDestroy()
        _binding = null
        }
        }