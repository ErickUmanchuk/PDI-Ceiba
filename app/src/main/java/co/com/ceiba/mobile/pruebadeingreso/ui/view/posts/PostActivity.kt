package co.com.ceiba.mobile.pruebadeingreso.ui.view.posts

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.PostsEntity
import co.com.ceiba.mobile.pruebadeingreso.data.models.posts_models.PostsModel
import co.com.ceiba.mobile.pruebadeingreso.databinding.ActivityPostBinding
import co.com.ceiba.mobile.pruebadeingreso.ui.view.posts.posts_rv_adapter.PostsAdapter
import co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel.PostsViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    private val postsViewModel: PostsViewModel by viewModels()

    private var adapter: PostsAdapter = PostsAdapter(mutableListOf())

    private var posts: MutableList<PostsEntity> = emptyList<PostsEntity>().toMutableList()

    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("data")
        userId = bundle?.get("userId") as Int
        val name = bundle.getString("name")
        val phone = bundle.getString("phone")
        val email = bundle.getString("email")

        binding.name.text = name
        binding.phone.text = phone
        binding.email.text = email

        val layoutManager = LinearLayoutManager(this)
        adapter = PostsAdapter(mutableListOf())
        binding.recyclerViewPostsResults.adapter = adapter
        binding.recyclerViewPostsResults.layoutManager = layoutManager

        postsViewModel.onCreate()

        postsViewModel.viewModelScope.launch(Dispatchers.Default) {
            composeRecycler()
        }

        postsViewModel.postsModel.observe(this, Observer {
            adapter.setItems(parseData(it))
        })

        postsViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

    }

    fun getAllPostsOnDb(): List<PostsEntity> {
        return postsViewModel.getAllPosts(userId)
    }

    fun composeRecycler() {
        posts = getAllPostsOnDb().toMutableList()
        if (posts.isNullOrEmpty()) {
            postsViewModel.insertPosts(posts)
        } else {
            (binding.recyclerViewPostsResults.adapter as PostsAdapter).setItems(posts)
        }
    }

    fun parseData(it: List<PostsModel>): MutableList<PostsEntity> {
        val parse = listOf<PostsEntity>().toMutableList()
        for (i in it)
            parse.add(PostsEntity(i.id, i.userId, i.title, i.body))
        return parse
    }

}