package com.example.onemorecofee

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.onemorecofee.databinding.FragmentResultadoBinding
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController
class ResultadoFragment : Fragment() {
    private var _binding: FragmentResultadoBinding? = null
    private val args: ResultadoFragmentArgs by navArgs()
    private val binding
        get() = checkNotNull(_binding) {
            "No se puede acceder al binding porque es nulo. ¿Está visible la vista?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recomendacions = Cafeteria.recomendacions(args.tipo)
        val nomeTipo = resources.getStringArray(R.array.tipos_cafe)[args.tipo]
        binding.tvCuriosidade.text = resources.getStringArray(R.array.curiosidades).random()


        binding.ivTipo.setImageResource(Cafeteria.imaxeTipo(args.tipo))
        binding.lvResultado.adapter = ArrayAdapter(
                requireContext(),
                R.layout.fila_cafe,
                recomendacions.map { cafe -> cafe.nome }
        )

        binding.tvCabeceira.text = resources.getQuantityString(
            R.plurals.recomendacions,
            recomendacions.size,
            recomendacions.size,
            nomeTipo
        )


        binding.lvResultado.setOnItemClickListener { _, _, position, _ ->
            val accion = ResultadoFragmentDirections.accionResultadoADetalle(args.tipo, position)
            findNavController().navigate(accion)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}