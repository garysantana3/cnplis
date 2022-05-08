package com.gosp.apps.cnplis.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gosp.apps.cnplis.databinding.LoginFragmentBinding
import com.gosp.apps.cnplis.main.MainViewModel
import com.gosp.apps.cnplis.models.request.LoginRequest

class LoginFragment: Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        binding.btDoLogin.setOnClickListener{
            if (!binding.etUser.text.isNullOrEmpty() && !binding.etPassword.text.isNullOrEmpty()){
                viewModel.doLogin(LoginRequest(
                    username = binding.etUser.text.toString(),
                    password = binding.etPassword.text.toString()
                ),requireActivity())
                viewModel.getMovies()
            }else{
                Toast.makeText(requireContext(), "Ingresa Usuario y Contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.etUser.text.clear()
        binding.etPassword.text.clear()
    }
}