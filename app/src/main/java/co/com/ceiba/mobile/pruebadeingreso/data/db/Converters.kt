package co.com.ceiba.mobile.pruebadeingreso.data.db

import androidx.room.TypeConverter
import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.Address

class Converters {

    @TypeConverter
    fun addressToString(address: Address): String {
        return address.toString()
    }

}