package com.gosp.apps.cnplis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.*
import com.gosp.apps.cnplis.main.MainViewModel
import com.gosp.apps.cnplis.ui.HomeFragment
import com.gosp.apps.cnplis.ui.LoginFragment
import com.gosp.apps.cnplis.ui.MovieDetailFragment
import com.gosp.apps.mlapp.mlapp.utils.Enums
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LifecycleObserver {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.viewState.observe(this, Observer {  t -> changeView(t) })
    }

    private fun changeView(state: Enums.ViewStates){
        when (state) {
            Enums.ViewStates.LOGIN -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commit()

            }
            Enums.ViewStates.HOME -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .addToBackStack("search_result")
                    .commit()

            }
            Enums.ViewStates.MOVIE_DETAIL -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, MovieDetailFragment.newInstance())
                    .addToBackStack("movie_detail")
                    .commit()

            }
        }
    }
}