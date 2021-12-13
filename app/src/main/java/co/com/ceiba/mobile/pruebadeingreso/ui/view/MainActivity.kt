package co.com.ceiba.mobile.pruebadeingreso.ui.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.databinding.ActivityMainBinding
import co.com.ceiba.mobile.pruebadeingreso.ui.view.main_rv_adapter.ClickListener
import co.com.ceiba.mobile.pruebadeingreso.ui.view.main_rv_adapter.MainAdapter
import co.com.ceiba.mobile.pruebadeingreso.ui.view.posts.PostActivity
import co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    private var users: MutableList<UserEntity> = emptyList<UserEntity>().toMutableList()

    private var adapter: MainAdapter = MainAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(mutableListOf(), this)
        binding.recyclerViewSearchResults.adapter = adapter
        binding.recyclerViewSearchResults.layoutManager = layoutManager

        mainViewModel.onCreate()

        mainViewModel.viewModelScope.launch(Dispatchers.Default) {
            composeRecycler()
        }

        mainViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //Do Nothing
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query = p0.toString().lowercase()
                filter(query)
            }

            override fun afterTextChanged(p0: Editable?) {
                //Do Nothing
            }

        })
    }

    fun getAllUsersOnDb(): List<UserEntity> {
        return mainViewModel.getAllUsers()
    }

    fun composeRecycler() {
        users = getAllUsersOnDb().toMutableList()
        if (users.isNullOrEmpty()) {
            mainViewModel.insertUsers(users)
        } else {
            (binding.recyclerViewSearchResults.adapter as MainAdapter).setItems(users)
        }
    }

    fun openPosts(user: UserEntity) {
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra("userId", user.id)
        intent.putExtra("name", user.name)
        intent.putExtra("email", user.email)
        startActivity(intent)
    }

    private fun filter(text: String) {
        val filterdNames: MutableList<UserEntity> = emptyList<UserEntity>().toMutableList()

        for (user in users) {
            if (user.name?.lowercase()!!.contains(text.lowercase())) {
                filterdNames.add(user)
            }
        }

        adapter.filterList(filterdNames)
    }

    override fun OnClick(userEntity: UserEntity) {
        openPosts(userEntity)
    }

}