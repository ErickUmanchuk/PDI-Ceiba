package co.com.ceiba.mobile.pruebadeingreso.domain.users

import co.com.ceiba.mobile.pruebadeingreso.data.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostsRepository) {

    suspend operator fun invoke() = repository.getAllPosts()

}