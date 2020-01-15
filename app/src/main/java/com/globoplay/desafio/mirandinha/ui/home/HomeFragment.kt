package com.globoplay.desafio.mirandinha.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.globoplay.desafio.mirandinha.R
import com.globoplay.desafio.mirandinha.util.SpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.listMovies.observe(this, Observer { movies ->
            home_recycler_view.setLayoutManager(GridLayoutManager(activity, 3))
            val spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid4)
            home_recycler_view.addItemDecoration(SpacingItemDecoration(spacingInPixels))
                home_recycler_view.adapter =
                    HomeListAdapter(
                        movies,
                        object :
                            HomeListAdapter.OnItemClickListener {
                            override fun onItemClick(position: Int) {
                                view?.findNavController()
                                    ?.navigate(R.id.navigation_favorite, arguments)
                            }
                        }
                    )
            })
    }
}