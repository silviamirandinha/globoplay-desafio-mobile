package com.globoplay.desafio.mirandinha.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globoplay.desafio.domain.Favorite
import com.globoplay.desafio.mirandinha.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.mirandinha.BuildConfig.*
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    val viewModel: DetailViewModel by viewModel()
    private var movie: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        movie = intent?.extras?.get("MOVIE") as Result
    }

    override fun onResume() {
        super.onResume()

        Picasso.with(this)
            .load(IMAGE_HOST +movie?.poster_path)
            .into(detail_image)

        Picasso.with(this)
            .load(IMAGE_HOST +movie?.backdrop_path)
            .transform(BlurTransformation(this, 25, 1))
            .into(detail_image_blur)

        detail_title.text = movie?.title

        detail_favorite.setOnClickListener {
            movie?.id?.let { movieId ->
                val favorite = Favorite(movieId)
                viewModel.addFavoriteMovie(favorite)
            }
        }

    }






}