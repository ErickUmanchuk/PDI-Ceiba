package co.com.ceiba.mobile.pruebadeingreso.data.network

import co.com.ceiba.mobile.pruebadeingreso.core.Constants
import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.UsersModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET(Constants.GET_USERS)
    suspend fun getAllUsers(): Response<List<UsersModel>>

}