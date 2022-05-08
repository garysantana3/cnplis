package com.gosp.apps.cnplis.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gosp.apps.cnplis.R
import com.gosp.apps.cnplis.databinding.RowMovieBinding
import com.gosp.apps.cnplis.models.Movie
import com.gosp.apps.cnplis.models.Route


class MovieAdapter(
    private val list: ArrayList<Movie>,
    private val routes: ArrayList<Route>,
    private val activity: Activity,
    private var onItemClick: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(list[position],routes[0], activity,onItemClick)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowMovieBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun binding(
            data: Movie,
            routes: Route,
            activity: Activity,
            onItemClick: (movie: Movie) -> Unit
        ) {
            binding.tvTitle.text = data.name
            binding.tvTime.text = "Duración: ${data.length}"
            val posterBaseUrl = routes.sizes.medium

            Glide
                .with(activity)
                .load(posterBaseUrl.replace("http://","https://") + data.media[0].resource)
                .asBitmap()
                .placeholder(R.drawable.ic_no_image)
                .skipMemoryCache(true)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.ivMovie)

            binding.row.setOnClickListener {
                onItemClick(data)
            }

        }
    }
}
