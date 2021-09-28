package asu.thr.myapplication.dag

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainActivityPresenter(databaseHelper: DatabaseHelper, networkUtils: NetworkUtils): MainActivityPresenter {
        return MainActivityPresenter(databaseHelper, networkUtils)
    }

}