package co.com.ceiba.mobile.pruebadeingreso.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user WHERE name LIKE :name")
    fun getUsersByName(name: String): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(users: List<UserEntity>)

}