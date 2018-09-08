package example.android.mvvmexample.database.DAOs

import android.arch.persistence.room.Dao
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import example.android.mvvmexample.database.entities.Item


@Dao
interface ItemDao {
    @Insert
    fun insert(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM Item")
    fun getItems(): LiveData<List<Item>>
}