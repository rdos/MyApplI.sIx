package asu.thr.myapplication.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "FlickrFetchr"

class CataasFetcher {

    private val flickrApi: CataasApi

    init {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging) // <-- this is the important line!
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://cataas.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        flickrApi = retrofit.create(CataasApi::class.java)
    }

    fun fetchCats(pCallback: CallBack) {
        val flickrRequest: Call<CataasEntity> = flickrApi.fetchPhotos()

        flickrRequest.enqueue(object : Callback<CataasEntity> {
            override fun onFailure(call: Call<CataasEntity>, t: Throwable) {
                Log.e("CATREPO", "Failed to fetch photos", t)
            }

            override fun onResponse(call: Call<CataasEntity>, entity: Response<CataasEntity>) {
                Log.d("catRePO.знаюзнаю", "Response received todo:import")
                val cataasEntity: CataasEntity? = entity.body()
                var cats: CataasEntity = cataasEntity?:mutableListOf()
                pCallback.onResponse(cats)
            }
        })
    }

    interface CallBack {
        fun onResponse(pCataasEntity: CataasEntity)
    }
}
//                galleryItems = galleryItems.filter {
//                    it.created_at.isBlank()
//                    return (index > superIndex)  {
//                        index++
//                    }
//                }
//                responseLiveData.value =  galleryItems.subList(0, superIndex)