package com.bignerdranch.android.photogallery

import com.google.gson.annotations.SerializedName

data class GalleryItem(
    var created_at: String = "",
    @SerializedName("id") var id_id: String = ""
)