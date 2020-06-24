package com.sai.marvelepoxy.view.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sai.marvelepoxy.R
import com.sai.marvelepoxy.extensions.hide
import com.sai.marvelepoxy.extensions.show
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.controllers.MarvelDetailController
import com.sai.marvelepoxy.view.viewstate.*
import com.sai.marvelepoxy.viewmodel.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class DetailActivity: AppCompatActivity(), MarvelDetailController.IDetailBackCallback {

    companion object {
        const val ARG_POSTER_ID = "arg_poster_id"
    }

    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val posterId = intent.getLongExtra(ARG_POSTER_ID, -1L)
        if (posterId == -1L) {
            finish()
            return
        }

        val marvelDetailController = MarvelDetailController(this)
        detail_recycler_view.setController(marvelDetailController)

        detailViewModel.posterLiveData.observe(this,
            Observer { viewstate ->
                when (viewstate) {
                    is DetailLoading -> detail_progress_bar.show()
                    is DetailSuccess -> {
                        detail_progress_bar.hide()
                        marvelDetailController.setData(viewstate.data)
                    }
                    is DetailError -> {
                        detail_progress_bar.hide()
                        Toast.makeText(this@DetailActivity,
                            "Error fetching data", Toast.LENGTH_LONG).show()
                    }
                }

            })

        detailViewModel.fetchMarvelPoster(posterId)
    }

    override fun onBackClicked() {
        onBackPressed()
        finish()
    }
}
