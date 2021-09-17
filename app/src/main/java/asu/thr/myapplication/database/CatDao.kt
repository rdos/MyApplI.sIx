package asu.thr.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CatDao {

    @Query("SELECT * FROM cat")
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
    fun addCat(catEntity: Cat)

    @Query("DELETE from cat ")
    fun deleteAll(): Int

    @Query("DELETE from cat where id = :idForDelete ")
    fun deleteId(idForDelete: Int): Int

}