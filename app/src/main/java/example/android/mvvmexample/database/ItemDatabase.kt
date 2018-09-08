package example.android.mvvmexample.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import example.android.mvvmexample.database.DAOs.ItemDao
import example.android.mvvmexample.database.entities.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}