package com.sai.marvelepoxy.view.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sai.marvelepoxy.R
import com.sai.marvelepoxy.extensions.hide
import com.sai.marvelepoxy.extensions.show
import com.sai.marvelepoxy.model.Poster
import com.sai.marvelepoxy.view.viewstate.Error
import com.sai.marvelepoxy.view.viewstate.Loading
import com.sai.marvelepoxy.view.viewstate.MainViewState
import com.sai.marvelepoxy.view.viewstate.Success
import com.sai.marvelepoxy.viewmodel.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.posterLiveData.observe(this,
            Observer { viewstate ->
                when (viewstate) {
                    is Loading -> main_progress_bar.show()
                    is Success -> {
                        main_progress_bar.hide()
                        Toast.makeText(this@MainActivity,
                            "Posters Loaded: ${viewstate.data.size}", Toast.LENGTH_LONG).show()
                    }
                    is Error -> {
                        main_progress_bar.hide()
                        Toast.makeText(this@MainActivity,
                            "Error fetching data", Toast.LENGTH_LONG).show()
                    }
                }
            })
    }
}
