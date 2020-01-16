package com.globoplay.desafio.mirandinha.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.globoplay.desafio.mirandinha.R
import com.globoplay.desafio.mirandinha.ui.detail.DetailActivity
import com.globoplay.desafio.mirandinha.ui.home.HomeListAdapter
import com.globoplay.desafio.mirandinha.util.SpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    val viewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.listFavoriteMovies.observe(this, Observer { movies ->
            favorite_recycler_view.setLayoutManager(GridLayoutManager(activity, 3))
            val spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid4)
            favorite_recycler_view.addItemDecoration(SpacingItemDecoration(spacingInPixels))
            favorite_recycler_view.adapter =
                HomeListAdapter(
                    movies,
                    object :
                        HomeListAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(activity, DetailActivity::class.java)
                            intent.putExtra("MOVIE",  movies[position])
                            startActivity(intent)
                        }
                    }
                )
        })
    }
}