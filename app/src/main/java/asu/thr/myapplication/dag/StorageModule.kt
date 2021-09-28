package asu.thr.myapplication.dag

import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun piOzdaDatabaseHelper(repository: Repository): DatabaseHelper {
        return DatabaseHelper(repository)
    }

    @Provides
    fun provideRepository(): Repository {
        return Repository()
    }


}

@Module
class NetworkModule {
    @Provides
    fun provideNetworkUtils(connectionManager: ConnectionManager): NetworkUtils {
        return NetworkUtils(connectionManager)
    }


//    @Provides
//    fun provideConnectionManager(): ConnectionManager {
//        val a = "aaa"
//        return ConnectionManager(a)
//    }

    @Provides
    fun provideConnectionManager(a: String ="aaa"): ConnectionManager {
        return ConnectionManager(a)
    }

    @Provides fun provideA(): String {
        return "aaa"
    }

}