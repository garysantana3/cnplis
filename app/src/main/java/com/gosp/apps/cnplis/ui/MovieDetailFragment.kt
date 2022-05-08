package com.gosp.apps.cnplis.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gosp.apps.cnplis.R
import com.gosp.apps.cnplis.databinding.MovieDetailFragmentBinding
import com.gosp.apps.cnplis.main.MainViewModel
import com.gosp.apps.cnplis.models.Movie

class MovieDetailFragment: Fragment () {

    private var _binding: MovieDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = MovieDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        viewModel.movieSelect.observe(viewLifecycleOwner) { bindingData(it) }
    }

    private fun bindingData(data: Movie){
        binding.tvName.text = "Nombre: ${data.name}"
        binding.tvClas.text = "Clasificación: ${data.rating}"
        binding.tvGen.text = "Género: ${data.genre}"
        binding.tvTime.text = "Duración: ${data.length}"
        binding.tvDescrip.text = "Sinopsis: ${data.synopsis}"

        val urlImage = (viewModel.route?.sizes?.medium?.replace("http://","https://") ?: "") + data.media[3].resource
        Log.e("LA IMAGEN", urlImage)

        Glide.with(activity)
            .load(urlImage)
            .asBitmap()
            .placeholder(R.drawable.ic_no_image)
            .skipMemoryCache(true)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.ivSlide)
    }
}