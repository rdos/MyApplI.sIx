package asu.thr.myapplication

import android.util.Log
import asu.thr.myapplication.api.CataasApi
import asu.thr.myapplication.api.CataasResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


private const val TAG = "FlickrFetchr"

class CaatsFetcher {

    private val flickrApi: CataasApi
    private val mCatDatabase: CatDatabase = CatDatabase.get()
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

    fun fetchCats() {
//        val responseLiveData: MutableLiveData<CataasResponse> = MutableLiveData()
        val flickrRequest: Call<CataasResponse> = flickrApi.fetchPhotos()
        val str: String?
//        str = flickrRequest.
//        println("r_dos $str")
        flickrRequest.enqueue(object : Callback<CataasResponse> {

            override fun onFailure(call: Call<CataasResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(call: Call<CataasResponse>, response: Response<CataasResponse>) {
                Log.d(TAG, "Response received")
                val cataasResponse: CataasResponse? = response.body()
                var cats: CataasResponse = cataasResponse?:mutableListOf()


                mCatDatabase.startTrans(cats)


//                galleryItems = galleryItems.filter {
//                    it.created_at.isBlank()
//                    return (index > superIndex)  {
//                        index++
//                    }
//                }
//                responseLiveData.value =  galleryItems.subList(0, superIndex)


            }
        })

    }
}