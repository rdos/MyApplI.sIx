package asu.thr.myapplication.di

import asu.thr.myapplication.Repo
import asu.thr.myapplication.dag.*
import dagger.Component


@Component(modules = [RepositoryModule::class, StorageModule::class, NetworkModule::class, MainModule::class])
interface AppComponent {
    fun getRepository(): Repo
    fun getNetworkUtils(): NetworkUtils
//    fun injectMainActivity(mainActivity: MainActivity)
    fun getMainActivityPresenter(): MainActivityPresenter
}