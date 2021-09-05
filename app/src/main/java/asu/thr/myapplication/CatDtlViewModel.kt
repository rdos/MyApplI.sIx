package asu.thr.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import asu.thr.myapplication.api.CataasResponse
import asu.thr.myapplication.z.TtestO

class CatDtlViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        TtestO().sayHello("CatViewModelFragmentDtl.onCleared")
    }
}