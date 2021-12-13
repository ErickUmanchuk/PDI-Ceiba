package co.com.ceiba.mobile.pruebadeingreso.data

import co.com.ceiba.mobile.pruebadeingreso.data.models.PostProvider
import co.com.ceiba.mobile.pruebadeingreso.data.models.posts_models.PostsModel
import co.com.ceiba.mobile.pruebadeingreso.data.network.PostsService
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val api: PostsService,
    private val postProvider: PostProvider
) {

    suspend fun getAllPosts(): List<PostsModel> {
        val response = api.getPosts()
        postProvider.posts = response
        return response
    }

}