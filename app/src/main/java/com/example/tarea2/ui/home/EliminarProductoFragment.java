package com.example.tarea2.ui.home;

import androidx.fragment.app.Fragment;

class EliminarProductoFragment : Fragment() {


// Recuperar los elementos enviados
private val args by navArgs<EliminarProductoFragmentArgs>()
private var _binding: FragmentEliminarProductoBinding? = null
private val binding get() = _binding!!
private lateinit var homeViewModel:HomeViewModel


        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentEliminarProductoBinding.inflate(inflater,container, false)


        // carga de Producto
        binding.etNombre.setText(args.productoArg.nombre)
        binding..etCorreoProductosetText(args.productoArg.correo)
        binding.etTelefono.setText(args.productoArg.telefono)
        binding.etWeb.setText(args.productoArg.web)

        binding.btEliminarProducto.setOnClickListener {eliminarProducto()}

        // Inflate the layout for this fragment

        return binding.root
        }


private fun eliminarProducto(){
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreoProducto.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val estadoproducto = binding.etEstadoProducto.text.toString()
        if (nombre.isNotEmpty()){
        val producto = Producto(args.productoArg.id,nombre, correo, telefono,estadoproducto)
        homeViewModel.eliminarProducto(producto)
        Toast.makeText(requireContext(),getText(R.string.ms_EliminarProducto),Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_eliminarProductoFragment_to_nav_home)
        }
        else{
        Toast.makeText(requireContext(),getString(R.string.ms_FaltaValores),Toast.LENGTH_LONG).show()
        }


        }

