package asu.thr.myapplication.z

class SomeGenericClass <T> {


    private var mSomeField: T? = null


    fun setSomeField(someData: T?) {
        mSomeField = someData
    }

    fun getSomeField(): T? {
        return mSomeField
    }
  
}