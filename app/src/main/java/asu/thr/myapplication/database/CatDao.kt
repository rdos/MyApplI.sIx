package asu.thr.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CatDao {

    @Query("SELECT * FROM Cat")
    fun getCats(): LiveData<List<Cat>>

    @Query("SELECT c.*\n" +
            "            FROM cat c \n" +
            "            where c.id <= ( SELECT max(c.id) FROM cat c \n" +
            "  \t\t\t\t\t\t\twhere (select count(*) from cat b where c.id >= b.id) <= :maxCnt)")
    fun getCats(maxCnt: Int): LiveData<List<Cat>>


//    @Query("SELECT * FROM crime WHERE id=(:id)")
//    fun getCrime(id: UUID): LiveData<Crime?>
//
//    @Update
//    fun updateCrime(crime: Crime)

    @Insert
    fun addCat(cat: Cat)

    @Query("DELETE from Cat ")
    fun deleteAll(): Int

    @Query("DELETE from cat where id = :idForDelete ")
    fun deleteId(idForDelete: Int): Int

}