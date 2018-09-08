package example.android.mvvmexample.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Item {
    @PrimaryKey(autoGenerate = true)
     var id: Int = 0
     var title: String? = null
     var body: String? = null

    constructor(title: String, body: String) {
        this.title = title
        this.body = body
    }
}