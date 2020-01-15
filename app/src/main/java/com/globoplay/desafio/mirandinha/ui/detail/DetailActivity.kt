package com.globoplay.desafio.mirandinha.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globoplay.desafio.mirandinha.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.mirandinha.BuildConfig.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    val viewModel: DetailViewModel by viewModel()
    private var movie: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_detail)

        movie = intent?.extras?.get("MOVIE") as Result
    }

    override fun onResume() {
        super.onResume()
        Picasso.with(this)
            .load(IMAGE_HOST +movie?.poster_path)
            .into(detail_image)
    }



}