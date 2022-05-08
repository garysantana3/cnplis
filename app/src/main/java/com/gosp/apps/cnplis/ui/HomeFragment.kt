package com.gosp.apps.cnplis.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gosp.apps.cnplis.databinding.HomeFragmentBinding
import com.gosp.apps.cnplis.main.MainViewModel
import com.gosp.apps.cnplis.models.Movie
import com.gosp.apps.cnplis.models.response.ListMoviesResponse
import com.gosp.apps.cnplis.ui.adapters.MovieAdapter

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        viewModel.dataList.observe(viewLifecycleOwner) { setDataAdapter(it) }
    }

    private fun setDataAdapter(list: ListMoviesResponse) {
        binding.rvListMovies.setHasFixedSize(true)
        val adapter = MovieAdapter(list.movies,list.routes, requireActivity(),
            onItemClick = { movie ->
                viewModel.getMovieDetail(movie,list.routes[3],requireContext())
            })
        binding.rvListMovies.adapter = adapter
    }
}