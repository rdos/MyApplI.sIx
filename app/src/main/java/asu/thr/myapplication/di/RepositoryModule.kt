package asu.thr.myapplication.di

import asu.thr.myapplication.Repo
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepo(): Repo {
        return Repo()
    }
}