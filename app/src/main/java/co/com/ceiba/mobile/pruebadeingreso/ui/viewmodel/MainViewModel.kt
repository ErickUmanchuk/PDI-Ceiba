package co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.ceiba.mobile.pruebadeingreso.core.App
import co.com.ceiba.mobile.pruebadeingreso.data.db.AppDatabase
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.UsersModel
import co.com.ceiba.mobile.pruebadeingreso.domain.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    val usersModel = MutableLiveData<List<UsersModel>>()
    val isLoading = MutableLiveData<Boolean>()
    private val database: AppDatabase = App.appInstance.db

    fun onCreate() {
        viewModelScope.launch(Dispatchers.Main) {
            isLoading.postValue(true)
            val result = getUsersUseCase()
            if (!result.isNullOrEmpty()) {
                usersModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getAllUsers(): List<UserEntity> {
        return database.usersDao().getAllUsers()
    }

    fun getUsersByName(name: String): List<UserEntity> {
        return database.usersDao().getUsersByName(name)
    }

    fun insertUsers(users: List<UsersModel>) {
        var entList: MutableList<UserEntity> = emptyList<UserEntity>().toMutableList()
        var userEntity: UserEntity
        for (user in users) {
            userEntity =
                UserEntity(user.id, user.name, user.username, user.email, user.phone, user.website)
            entList.add(userEntity)
        }
        database.usersDao().insertAllUsers(entList)
    }

}