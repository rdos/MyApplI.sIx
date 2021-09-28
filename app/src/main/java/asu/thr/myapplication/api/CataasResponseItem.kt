package asu.thr.myapplication.api

import com.google.gson.annotations.SerializedName

data class CataasResponseItem(
    var created_at: String = "",
        @SerializedName("id") var id_id: String = ""
)