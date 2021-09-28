package asu.thr.myapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides

//@Module
class ZZZContextModule(context: Context) {
    var context: Context

//    @Provides
    fun context(): Context {
        return context.getApplicationContext()
    }

    init {
        this.context = context
    }
}