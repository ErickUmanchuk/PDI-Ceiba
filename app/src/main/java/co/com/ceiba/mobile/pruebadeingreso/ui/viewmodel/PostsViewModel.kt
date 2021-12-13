package co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.ceiba.mobile.pruebadeingreso.core.App
import co.com.ceiba.mobile.pruebadeingreso.data.db.AppDatabase
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.PostsEntity
import co.com.ceiba.mobile.pruebadeingreso.data.models.posts_models.PostsModel
import co.com.ceiba.mobile.pruebadeingreso.domain.users.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    val postsModel = MutableLiveData<List<PostsModel>>()
    val isLoading = MutableLiveData<Boolean>()
    private val database: AppDatabase = App.appInstance.db

    fun onCreate() {
        viewModelScope.launch(Dispatchers.Main) {
            isLoading.postValue(true)
            val result = getPostsUseCase()
            Log.d("Erick", "ViewModel $result")
            if (!result.isNullOrEmpty()) {
                postsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getAllPosts(userId: Int): List<PostsEntity> {
        return database.postsDao().getPostsByUserId(userId)
    }

    fun insertPosts(posts: List<PostsEntity>) {
        database.postsDao().insertAllPosts(posts)
    }

}