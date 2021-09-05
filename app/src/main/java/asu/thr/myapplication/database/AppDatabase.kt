package asu.thr.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ Cat::class ], version=2)
@TypeConverters(CrimeTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun catDao(): CatDao
}

val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
        )
        database.execSQL(
            "CREATE TABLE Cat (id INTEGER PRIMARY KEY AUTOINCREMENT, id_id TEXT NOT NULL, date_date TEXT NOT NULL, url_url TEXT NOT NULL)"
        )
        database.execSQL(
            "insert into Cat(id_id, date_date, url_url) values(\"2476e2d9-df44-4ca5-ae75-0ee18ddbbee2\", \"2015-11-04T18:36:33.340Z\", \"www.thr.su/hello\")"
        )
    }
}
//val migration_1_3 = object : Migration(1, 3) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "CREATE TABLE Cat (id TEXT NOT NULL, id_id TEXT NOT NULL, date_date TEXT NOT NULL, url_url TEXT NOT NULL, PRIMARY KEY(id))"
//        )
//        database.execSQL(
//            "insert into Cat(id, id_id, date_date, url_url) values(3, \"595f280c557291a9750ebf80\", \"2015-11-04T18:36:33.340Z\", \"www.thr.su/hello\")"
//        )
//    }
//}
//val migration_3_4 = object : Migration(3, 4) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "delete from cat;"
//        )
//        database.execSQL(
//            "insert into Cat(id, id_id, date_date, url_url) values(3, \"2476e2d9-df44-4ca5-ae75-0ee18ddbbee2\", \"2015-11-04T18:36:33.340Z\", \"www.thr.su/hello\")"
//        )
//    }