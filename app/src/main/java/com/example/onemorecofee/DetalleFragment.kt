package com.example.onemorecofee


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.onemorecofee.databinding.FragmentDetalleBinding
class DetalleFragment : Fragment() {
    private val args: DetalleFragmentArgs by navArgs()
    private var _binding: FragmentDetalleBinding? = null
    private val binding get() = checkNotNull(_binding) {
        "No se puede acceder al binding porque es nulo. ¿Está visible la vista?"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cafe = Cafeteria.cafe(args.tipo, args.indice)
        binding.ivCafe.setImageResource(cafe.imaxe)
        binding.ivCafe.contentDescription = cafe.nome
        binding.tvNome.text = cafe.nome
        binding.tvDescricion.text = cafe.descricion
        binding.rbIntensidade.rating = cafe.intensidade.toFloat()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}