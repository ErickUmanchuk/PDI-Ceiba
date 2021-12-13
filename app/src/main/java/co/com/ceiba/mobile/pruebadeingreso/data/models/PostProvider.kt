package co.com.ceiba.mobile.pruebadeingreso.data.models

import co.com.ceiba.mobile.pruebadeingreso.data.models.posts_models.PostsModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostProvider @Inject constructor() {
    var posts: List<PostsModel> = emptyList()
}