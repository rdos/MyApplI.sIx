package asu.thr.myapplication;

import android.app.Application;

import asu.thr.myapplication.di.AppComponent;

public class App extends Application {

    private AppComponent mAppComp;

    @Override
    public void onCreate() {
        super.onCreate();
    }


}

