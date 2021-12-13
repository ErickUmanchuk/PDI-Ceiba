package co.com.ceiba.mobile.pruebadeingreso.domain.users

import co.com.ceiba.mobile.pruebadeingreso.data.UsersRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    suspend operator fun invoke() = repository.getAllUsers()

}