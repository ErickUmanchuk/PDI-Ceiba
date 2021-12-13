package co.com.ceiba.mobile.pruebadeingreso.data.db.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndPosts(
    @Embedded val user: UserEntity,
    @Relation(parentColumn = "id", entityColumn = "userId", entity = PostsEntity::class)
    val postsList: List<PostsEntity>
)