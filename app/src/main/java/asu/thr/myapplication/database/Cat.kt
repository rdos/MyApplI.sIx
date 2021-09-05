package asu.thr.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Cat(@PrimaryKey(autoGenerate = true) val id: Int?,
               var id_id: String = "",
               var date_date: String = Date().toString(),
               var url_url: String = "")
     {

    val photoFileName
        get() = "IMG_$id.jpg"

    val urlAddress
        get() = "$url_url$id_id"
}