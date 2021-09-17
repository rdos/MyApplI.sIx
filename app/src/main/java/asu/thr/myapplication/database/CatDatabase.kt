package asu.thr.myapplication.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import asu.thr.myapplication.api.CataasEntity
import java.io.File
import java.util.concurrent.Executors

private const val DATABASE_NAME = "cat-database"

class CatDatabase private constructor(context: Context) {

    companion object {
        private var INSTANCE: CatDatabase? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CatDatabase(context)
            }
        }

        fun get(): CatDatabase {
            return INSTANCE ?:
            throw IllegalStateException("CatDatabase must be initialized")
        }
    }

    private val mDatabase : AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).addMigrations(migration_1_2)
        .build()
    private val catDao = mDatabase.catDao()
    private val mExecutor = Executors.newSingleThreadExecutor()
    private val filesDir = context.applicationContext.filesDir

    fun getCats(): LiveData<List<Cat>> = catDao.getCats()

    fun getCats(maxCnt: Int): LiveData<List<Cat>> {
        return catDao.getCats(maxCnt)
    }

//
//    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)
//
//    fun updateCrime(crime: Crime) {
//        executor.execute {
//            crimeDao.updateCrime(crime)
//        }
//    }

    fun addCat(catEntity: Cat) {
        mExecutor.execute {
            catDao.addCat(catEntity)
        }
    }

    fun deleteCat(idForDelete: Int){
        mExecutor.execute {
            catDao.deleteId(idForDelete)
        }
    }

    fun getPhotoFile(catEntity: Cat): File = File(filesDir, catEntity.photoFileName)

    fun startTrans(pCatEntity: CatEntity) {
        mExecutor.execute {
            mDatabase.runInTransaction {
                catDao.deleteAll()
                for (catEntity in pCatEntity) {
                        catDao.addCat(catEntity)
                }

            }
        }
    }


}