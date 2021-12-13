package co.com.ceiba.mobile.pruebadeingreso.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.PostsEntity

@Dao
interface PostsDao {

    @Query("SELECT * FROM posts WHERE userId = :userId")
    fun getPostsByUserId(userId: Int): List<PostsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPosts(posts: List<PostsEntity>)

}