package asu.thr.myapplication

import androidx.lifecycle.LiveData
import asu.thr.myapplication.api.CataasEntity
import asu.thr.myapplication.api.CataasFetcher
import asu.thr.myapplication.database.Cat
import asu.thr.myapplication.database.CatDatabase


class Repo : Any(), CataasFetcher.CallBack {

    private val mCatDatabase: CatDatabase = CatDatabase.get()
    init {
        CataasFetcher().fetchCats(this)
    }

    fun getCats(): LiveData<List<Cat>> = mCatDatabase.getCats()
    fun deleteCat(idForDelete: Int) = mCatDatabase.deleteCat(idForDelete)



    override fun onResponse(pCataasEntity: CataasEntity) {
        mCatDatabase.startTrans(MappER().toCatEntity(pCataasEntity))
    }

//    companion object {
//        private var INSTANCE: Repo? = null
//
//        fun initialize(context: Context) {
//            if (INSTANCE == null) {
//                CatDatabase.initialize(context)
//                INSTANCE = Repo()
//            }
//        }
//
//        fun get(): Repo {
//            return INSTANCE ?:
//            throw IllegalStateException("CatRepo must be initialized")
//        }
//    }
}