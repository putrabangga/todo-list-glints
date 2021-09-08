package com.application.todolistglints.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.application.todolistglints.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val typeMovie = "movie"
        const val typeTvShow = "tvshow"
        const val extraType = "extra_type"
        const val extraMovie = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}