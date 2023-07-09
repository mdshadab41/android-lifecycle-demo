package com.example.android_lifecycle_demo_project

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val timerData = MutableLiveData<String>()

    private val timer = object : CountDownTimer(60000, 3000) {

        override fun onTick(millisUntilFinished: Long) {

            timerData.postValue("$millisUntilFinished")

        }

        override fun onFinish() {
            timerData.postValue("Finish")

        }
    }

    fun start(){
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}