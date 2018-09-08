package example.android.mvvmexample.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import example.android.mvvmexample.ui.adapters.ItemsAdapter
import example.android.mvvmexample.R
import example.android.mvvmexample.database.entities.Item
import example.android.mvvmexample.viewModels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var list = ArrayList<Item>()
    private  var viewModel: MainViewModel?=null

    // TAG for Logging
    private val TAG = this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = ItemsAdapter(list)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel?.getListItems()?.observe(this, Observer { _ ->
            // update DataSet
            Log.e("Main Activity", "_AdapterIsUpdatedFromViewModel")
            list.clear()
            list.addAll(viewModel?.getListItems()?.value!!)
            recyclerview.adapter.notifyDataSetChanged()
        })

        add_btn.setOnClickListener {
            val intent = Intent(this, AddItemScreen::class.java)
            startActivity(intent)
        }
    }
}
