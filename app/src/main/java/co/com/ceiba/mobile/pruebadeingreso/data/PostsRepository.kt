package co.com.ceiba.mobile.pruebadeingreso.data

import co.com.ceiba.mobile.pruebadeingreso.data.models.UserProvider
import co.com.ceiba.mobile.pruebadeingreso.data.network.UsersService
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val api: UsersService,
    private val userProvider: UserProvider
) {
}