package co.com.ceiba.mobile.pruebadeingreso.data.network

import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.UsersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersService @Inject constructor(private val api: ApiClient) {

    suspend fun getUsers(): List<UsersModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllUsers()
            response.body() ?: emptyList()
        }
    }

}