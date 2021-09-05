package asu.thr.myapplication

import androidx.lifecycle.*
import asu.thr.myapplication.database.Cat
import asu.thr.myapplication.z.TtestO

class CatsListViewModel : ViewModel() {
    private val mCatRepository = CatDatabase.get()
    private val mCatMaxCntLiveData = MutableLiveData<Int>()

    init {
        CaatsFetcher().fetchCats()
    }

//    val catsLiveDate: LiveData<List<Cat>> =
//        Transformations.switchMap(mCatMaxCntLiveData) { maxCnt ->
//        mCatRepository.getCats(maxCnt)
//    }


    val catsLiveDate: LiveData<List<Cat>> = mCatRepository.getCats()

    override fun onCleared() {
        super.onCleared()
        TtestO().sayHello("GalleryViewModel.onCleared")
    }

    fun showNewTODO(maxCnt: Int) {
        mCatMaxCntLiveData.value = maxCnt
    }

    fun deleteCat(idForDelete: Int) {
        mCatRepository.deleteCat(idForDelete)
    }

}