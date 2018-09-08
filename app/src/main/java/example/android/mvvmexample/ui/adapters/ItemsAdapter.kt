package example.android.mvvmexample.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import example.android.mvvmexample.R
import example.android.mvvmexample.database.entities.Item
import kotlinx.android.synthetic.main.row.view.*

class ItemsAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemsAdapter.ItemRowHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRowHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ItemRowHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemRowHolder, position: Int) {
        val item = items[position]
        val v = holder.view
        v.tv_body.text = item.body
        v.tv_title.text = item.title
    }

    inner class ItemRowHolder(val view: View) : RecyclerView.ViewHolder(view)

}