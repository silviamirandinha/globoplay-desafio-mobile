package com.globoplay.desafio.mirandinha.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
            text_home.text = it
        })

        viewModel.listMovies.observe(this, Observer {
           Toast.makeText(context, it[0].title, Toast.LENGTH_SHORT).show()
           /*it.forEach { movies ->
              Toast.makeText(context, movies.title, Toast.LENGTH_SHORT).show()
            }*/
        })
    }
}