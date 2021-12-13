package co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel

import androidx.lifecycle.ViewModel
import co.com.ceiba.mobile.pruebadeingreso.domain.users.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {



}