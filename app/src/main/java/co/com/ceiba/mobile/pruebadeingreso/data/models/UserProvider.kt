package co.com.ceiba.mobile.pruebadeingreso.data.models

import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.UsersModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProvider @Inject constructor() {
    var users: List<UsersModel> = emptyList()
}