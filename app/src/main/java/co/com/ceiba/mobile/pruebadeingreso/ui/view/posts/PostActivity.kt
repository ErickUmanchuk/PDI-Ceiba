package co.com.ceiba.mobile.pruebadeingreso.ui.view.posts

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.databinding.ActivityPostBinding
import co.com.ceiba.mobile.pruebadeingreso.ui.viewmodel.PostsViewModel

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    private val postsViewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.extras!!.getString("userId")
        val name = intent.extras!!.getString("userId")
        val phone = intent.extras!!.getString("userId")
        val email = intent.extras!!.getString("userId")
    }
}