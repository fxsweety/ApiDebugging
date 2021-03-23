package com.sample.apidebugging

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.sample.apidebugging.api.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = MainViewModel()
        progress.visibility = View.INVISIBLE
        light_container.visibility = View.INVISIBLE
        status_button.setOnClickListener {
            progress.visibility = View.VISIBLE
            setLightStatus()
        }

    }



    private fun setLightStatus() {
        viewModel.light.observe(this, Observer {
            progress.visibility = View.INVISIBLE
            light_container.visibility = View.VISIBLE
            light_name.text = it.name
            light_image.setImageDrawable(if (it.status) getDrawable(R.drawable.light_on) else getDrawable(R.drawable.light_off) )
        })
    }

}


