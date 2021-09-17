package asu.thr.myapplication.api;

import retrofit2.Call
import retrofit2.http.GET

interface CataasApi {

    @GET("api/cats?tags=cute" //+
//            "&api_key=4f721bbafa75bf6d2cb5af54f937bb70" +
//            "&format=json" +
//            "&nojsoncallback=1" +
//            "&extras=url_s"
        )
    fun fetchPhotos(): Call<CataasEntity>
}
