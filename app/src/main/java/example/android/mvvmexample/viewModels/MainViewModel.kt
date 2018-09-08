package example.android.mvvmexample.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import example.android.mvvmexample.database.entities.Item
import example.android.mvvmexample.database.repository.RepositoryImpl


class MainViewModel : ViewModel() {
    private val TAG = this.javaClass.name

    private var listItems: LiveData<List<Item>>? = null

    fun getListItems(): LiveData<List<Item>> {

        if (listItems == null) {
            Log.e(TAG, "_ListItemsIsNULL")
            listItems = MutableLiveData<List<Item>>()
            loadItemsFromRepository()
        }
        Log.e(TAG, "_ReturningFromViewModel")
        return listItems as LiveData<List<Item>>
    }

    private fun loadItemsFromRepository() {
        Log.e(TAG, "_LoadFromDB")
        listItems = RepositoryImpl.instance.getItems()
    }
}