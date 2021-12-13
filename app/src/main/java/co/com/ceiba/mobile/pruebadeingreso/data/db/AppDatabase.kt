package co.com.ceiba.mobile.pruebadeingreso.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import co.com.ceiba.mobile.pruebadeingreso.core.Constants
import co.com.ceiba.mobile.pruebadeingreso.data.db.daos.PostsDao
import co.com.ceiba.mobile.pruebadeingreso.data.db.daos.UsersDao
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.PostsEntity
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity
import javax.inject.Inject

@Database(entities = [UserEntity::class, PostsEntity::class], version = Constants.DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
    abstract fun postsDao(): PostsDao
}