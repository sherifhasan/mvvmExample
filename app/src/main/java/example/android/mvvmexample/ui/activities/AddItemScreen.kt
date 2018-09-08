package example.android.mvvmexample.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import example.android.mvvmexample.R
import example.android.mvvmexample.database.entities.Item
import example.android.mvvmexample.database.repository.RepositoryImpl
import kotlinx.android.synthetic.main.activity_add_item_screen.*

class AddItemScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item_screen)
        add_btn.setOnClickListener {
            Log.e("AddItemScreen", "_onClickInvoked")
            RepositoryImpl.instance.addItem(Item(edtTitle.text.toString(), body.text.toString()))
            // show toast
            Toast.makeText(this@AddItemScreen, "Record Added", Toast.LENGTH_SHORT).show();
            // get back to main activity
            finish()
        }
    }
}
