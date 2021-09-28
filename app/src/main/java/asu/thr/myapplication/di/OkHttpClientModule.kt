package asu.thr.myapplication.di

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File


//@Module(includes = [ZZZContextModule::class])
@Module
class OkHttpClientModule {
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor?): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
//            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
//
//    @Provides
//    fun cache(cacheFile: File?): Cache {
//        return Cache(cacheFile, 10 * 1000 * 1000) //10 MB
//    }

//    @Provides
//    fun file(context: Context): File {
//        val file = File(context.getCacheDir(), "HttpCache")
//        file.mkdirs()
//        return file
//    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Timber.d(message) }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}