package com.lego.mydiablo.view

import android.app.Application
import com.lego.mydiablo.di.AppComponent
import com.lego.mydiablo.di.DaggerAppComponent

class DiabloApplication: Application() {

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().build()
    }
}