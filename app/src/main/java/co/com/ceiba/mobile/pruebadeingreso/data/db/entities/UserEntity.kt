package co.com.ceiba.mobile.pruebadeingreso.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.Address

@Entity(tableName = "user", indices = [Index(value = ["id"], unique = true)])
data class UserEntity(

    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "website") val website: String?
    //@ColumnInfo(name = "address") val address: Address?

)