package asu.thr.myapplication.dag

import asu.thr.myapplication.api.CataasFetcher
import asu.thr.myapplication.database.CatDatabase

typealias ConnectionManager2 = CataasFetcher
typealias Repository2 = CatDatabase

open class Repository {

}

class ConnectionManager (val a: String) : Repository()