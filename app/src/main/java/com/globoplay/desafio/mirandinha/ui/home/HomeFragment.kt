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
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.text.observe(this, Observer {
            title_home.text = it
        })

        viewModel.listMovies.observe(this, Observer { movies ->
            movies?.let {
                home_recycler_view.layoutManager = GridLayoutManager(context, 3)
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
            }})
    }
}