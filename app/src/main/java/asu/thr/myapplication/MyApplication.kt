package asu.thr.myapplication

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CatDatabase.initialize(this)
    }
}