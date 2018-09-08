package example.android.mvvmexample.database.repository

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.os.AsyncTask
import android.util.Log
import example.android.mvvmexample.MVVMExample
import example.android.mvvmexample.database.ItemDatabase
import example.android.mvvmexample.database.entities.Item


class RepositoryImpl// constructor
private constructor() : Repository {
    private var itemDB: ItemDatabase? = null
    private val TAG = this.javaClass.name

    init {
        initDB()
    }

    private fun initDB() {
        Log.e(TAG, "_DataBaseInit")
        itemDB = Room.databaseBuilder(MVVMExample.getAppContext(),
                ItemDatabase::class.java, "ItemDatabase").build()
    }

    override fun addItem(item: Item) {
        Log.e(TAG, "_ItemIsAddedToDB")
        DataBaseOperation(item, INSERT_OPERATION).execute()
    }

    override fun deleteItem(item: Item) {
        Log.e(TAG, "_ItemIsDeletedFromDB")
        itemDB?.itemDao()?.delete(item)
    }

    override fun getItems(): LiveData<List<Item>> {
        Log.e(TAG, "_GetItemsFromDB")
        return itemDB?.itemDao()!!.getItems()
    }

    // Async
    @SuppressLint("StaticFieldLeak")
    internal inner class DataBaseOperation(var item: Item, var operation: Int) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            Log.e(TAG, "_doInBackgroundInvoked")
            // INSERT operation
            if (operation == INSERT_OPERATION) itemDB?.itemDao()?.insert(item)
            // else delete ...
            return null
        }
    }

    companion object {

        private val repository = RepositoryImpl()

        // operations constants
        private val INSERT_OPERATION = 0
        private val DELETE_OPERATION = 1

        val instance: Repository
            get() = repository
    }

}