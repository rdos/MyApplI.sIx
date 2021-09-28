package asu.thr.myapplication.di

import asu.thr.myapplication.api.CataasApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpClientModule::class])
class BLABLAModule {
    @Provides
    fun provideCataasApi(retrofit: Retrofit): CataasApi {
        return retrofit.create(CataasApi::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient?,
                        gsonConverterFactory: GsonConverterFactory?,
                        gson: Gson?
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    fun provideGsonConverterFactory(gson: Gson?): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }
}