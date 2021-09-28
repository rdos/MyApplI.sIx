package asu.thr.myapplication.di

import asu.thr.myapplication.api.CataasApi
import dagger.Component
//@Component(modules = [RandomUsersModule::class, PicassoModule::class])


@Component(modules = [BLABLAModule::class])
interface BLABLAComponent {
    fun getRandomUserService(): CataasApi
//    fun getPicasso(): Picasso
}