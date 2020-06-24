package com.sai.marvelepoxy.view.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.sai.marvelepoxy.R
import com.sai.marvelepoxy.extensions.hide
import com.sai.marvelepoxy.extensions.show
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.controllers.MarvelHeroController
import com.sai.marvelepoxy.view.ui.detail.DetailActivity
import com.sai.marvelepoxy.view.viewstate.Error
import com.sai.marvelepoxy.view.viewstate.Loading
import com.sai.marvelepoxy.view.viewstate.Success
import com.sai.marvelepoxy.viewmodel.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MarvelHeroController.IControllerCallback {

    private val mainViewModel by viewModels<MainViewModel>()
    private val posters = mutableListOf<Poster>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marvelHeroController = MarvelHeroController(this).apply {
            spanCount = 2
        }

        val gridLayoutManager = GridLayoutManager(this@MainActivity, 2)
        gridLayoutManager.spanSizeLookup = marvelHeroController.spanSizeLookup

        main_recycler_view.apply {
            layoutManager = gridLayoutManager
            setController(marvelHeroController)
        }

        mainViewModel.posterLiveData.observe(this,
            Observer { viewstate ->
                when (viewstate) {
                    is Loading -> main_progress_bar.show()
                    is Success -> {
                        main_progress_bar.hide()
                        posters.clear()
                        viewstate.data.forEach { posters.add(it) }
                        marvelHeroController.setData(posters)
                    }
                    is Error -> {
                        main_progress_bar.hide()
                        Toast.makeText(this@MainActivity,
                            "Error fetching data", Toast.LENGTH_LONG).show()
                    }
                }
            })


    }

    override fun onHeroClicked(poster: Poster) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.ARG_POSTER_ID, poster.id)

        startActivity(intent)
    }
}
