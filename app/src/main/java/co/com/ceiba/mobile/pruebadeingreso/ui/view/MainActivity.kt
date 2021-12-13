package co.com.ceiba.mobile.pruebadeingreso.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.data.models.users_models.UsersModel
import co.com.ceiba.mobile.pruebadeingreso.databinding.ActivityMainBinding
import co.com.ceiba.mobile.pruebadeingreso.ui.view.main_rv_adapter.MainAdapter
import co.com.ceiba.mobile.pruebadeingreso.ui.view.posts.PostActivity
import co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewSearchResults.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MainAdapter(mutableListOf())
        }

        mainViewModel.onCreate()

        mainViewModel.usersModel.observe(this, Observer {
            checkUsers(it)
        })

        mainViewModel.viewModelScope.launch(Dispatchers.Default) {
            composeRecycler()
        }

        mainViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

    }

    private fun checkUsers(usersList: List<UsersModel>) {
        mainViewModel.viewModelScope.launch(Dispatchers.IO) {
            if (getAllUsersOnDb().isEmpty()) {
                mainViewModel.insertUsers(usersList)
            }
        }
    }

    suspend fun getAllUsersOnDb(): List<UserEntity> {
        return mainViewModel.getAllUsers()
    }

    suspend fun composeRecycler() {
        (binding.recyclerViewSearchResults.adapter as MainAdapter).setItems(getAllUsersOnDb())
    }

    fun openPosts() {
        val intent = Intent(this, PostActivity::class.java)
        startActivity(intent)
    }

}