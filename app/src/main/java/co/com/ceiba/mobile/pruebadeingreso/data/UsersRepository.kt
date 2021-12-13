package co.com.ceiba.mobile.pruebadeingreso.data

import co.com.ceiba.mobile.pruebadeingreso.data.models.UserProvider
import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.UsersModel
import co.com.ceiba.mobile.pruebadeingreso.data.network.UsersService
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val api: UsersService,
    private val userProvider: UserProvider
) {

    suspend fun getAllUsers(): List<UsersModel> {
        val response = api.getUsers()
        userProvider.users = response
        return response
    }

}