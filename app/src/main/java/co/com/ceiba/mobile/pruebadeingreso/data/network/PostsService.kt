package co.com.ceiba.mobile.pruebadeingreso.data.network

import co.com.ceiba.mobile.pruebadeingreso.data.models.posts_models.PostsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostsService @Inject constructor(private val api: ApiClient) {

    suspend fun getPosts(): List<PostsModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPosts()
            response.body() ?: emptyList()
        }
    }

}