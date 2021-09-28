package asu.thr.myapplication

import android.app.Application
import android.content.Context
import asu.thr.myapplication.di.AppComponent
import asu.thr.myapplication.di.DaggerAppComponent
import timber.log.Timber

class MyApplication : Application() {

    lateinit var appComp: AppComponent

    override fun onCreate() {
        super.onCreate()
//        Repo.initialize(this)
        appComp = DaggerAppComponent.create()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        fun appComponent(context: Context) =
            (context.applicationContext as MyApplication).appComp
    }
}

val Context.appComponent1: AppComponent
    get() =
        MyApplication.appComponent(this)