package com.sample.apidebugging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository: LightRepository = LightRepository()

    val light = liveData(Dispatchers.IO) {
        val lightStatus = repository.getLightStatus()

        emit(lightStatus)
    }
}