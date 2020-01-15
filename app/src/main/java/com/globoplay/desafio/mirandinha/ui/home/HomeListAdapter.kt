package com.globoplay.desafio.mirandinha.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.globoplay.desafio.mirandinha.R
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.remote.BuildConfig
import com.squareup.picasso.Picasso

class HomeListAdapter(private val movies: List<Result>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<HomeListAdapter.MovieViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_home, parent, false)
        this.context = parent.context
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Picasso.with(context)
            .load(BuildConfig.IMAGE_HOST+movies[position].poster_path)
            .into(holder.image)
        holder.item.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: LinearLayout = itemView.findViewById(R.id.movie_line_item)
        var image: ImageView = itemView.findViewById(R.id.movie_image)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}