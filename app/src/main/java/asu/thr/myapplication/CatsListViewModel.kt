package asu.thr.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asu.thr.myapplication.database.Cat
import asu.thr.myapplication.z.TtestO

class CatsListViewModel : ViewModel() {
    private val mCatRepo = Repo.get()
    private val mCatMaxCntLiveData = MutableLiveData<Int>()

//    val catsLiveDate: LiveData<List<Cat>> =
//        Transformations.switchMap(mCatMaxCntLiveData) { maxCnt ->
//        mCatRepository.getCats(maxCnt)
//    }

    val catsLiveDate: LiveData<List<Cat>> = mCatRepo.getCats()

    override fun onCleared() {
        super.onCleared()
        TtestO().sayHello("GalleryViewModel.onCleared")



    }

    fun showNewTODO(maxCnt: Int) {
        mCatMaxCntLiveData.value = maxCnt
    }

    fun deleteCat(idForDelete: Int) {
        mCatRepo.deleteCat(idForDelete)
    }

}