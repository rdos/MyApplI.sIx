package asu.thr.myapplication.database

import androidx.lifecycle.LiveData


abstract class Resource {
    abstract var id: Long
    abstract var location: String
}

data class Book (
    override var id: Long = 0,
    override var location: String = "",
    var isbn: String
) : Resource()

data class CatBootstrap(val test: String, override var id: Long, override var location: String): Resource() ,CatDao {
    init {

    }
    override fun getCats(): LiveData<List<Cat>> {
        TODO("Not yet implemented")
    }

    override fun getCats(maxCnt: Int): LiveData<List<Cat>> {
        TODO("Not yet implemented")
    }

    override fun addCat(catEntity: Cat) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(): Int {
        TODO("Not yet implemented")
    }

    override fun deleteId(idForDelete: Int): Int {
        TODO("Not yet implemented")
    }

}
