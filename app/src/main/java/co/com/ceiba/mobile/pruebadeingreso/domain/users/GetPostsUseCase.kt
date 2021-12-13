package co.com.ceiba.mobile.pruebadeingreso.domain.users

import co.com.ceiba.mobile.pruebadeingreso.data.PostsRepository
import co.com.ceiba.mobile.pruebadeingreso.data.UsersRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostsRepository) {
}