package com.example.onemorecofee
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


import com.example.onemorecofee.databinding.FragmentSeleccionBinding


class SeleccionFragment : Fragment() {
    private var _binding: FragmentSeleccionBinding? = null
    //private val args: ResultadoFragmentArgs by navArgs()

    private val binding get() = checkNotNull(_binding) {
        "No se puede acceder al binding porque es nulo. ¿Está visible la vista?"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeleccionBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                binding.spTipoCafe.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        binding.ivCabeceira.setImageResource(Cafeteria.imaxeTipo(position))
                        binding.tvDescricionTipo.text = resources.getStringArray(R.array.descricions_tipo)[position]
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }

                binding.btnRecomendar.setOnClickListener {
                    irAoResultado(binding.spTipoCafe.selectedItemPosition)
                }
                binding.btnAoChou.setOnClickListener {
                    irAoResultado(resources.getStringArray(R.array.tipos_cafe).indices.random())

                }
    }
    private fun irAoResultado(tipo: Int) {
        val accion = SeleccionFragmentDirections.accionSeleccionAResultado(tipo)
        findNavController().navigate(accion)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
