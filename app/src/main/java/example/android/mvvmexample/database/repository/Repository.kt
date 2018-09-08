package example.android.mvvmexample.database.repository

import android.arch.lifecycle.LiveData
import example.android.mvvmexample.database.entities.Item


interface Repository {
    fun addItem(item: Item)
    fun deleteItem(item: Item)
    fun getItems(): LiveData<List<Item>>
}