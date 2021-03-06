package co.com.ceiba.mobile.pruebadeingreso.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "posts", indices = [Index(value = ["id"], unique = true)])
class PostsEntity(

    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "userId") val userId: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "body") val body: String?

)