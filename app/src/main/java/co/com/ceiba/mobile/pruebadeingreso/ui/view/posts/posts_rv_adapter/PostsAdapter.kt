package co.com.ceiba.mobile.pruebadeingreso.ui.view.posts.posts_rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.PostsEntity
import co.com.ceiba.mobile.pruebadeingreso.databinding.PostListItemBinding

class PostsAdapter(var posts: MutableList<PostsEntity>) :
    RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PostViewHolder(
            PostListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.setData(posts[position])
    }

    override fun getItemCount() = posts.size

    fun setItems(items: List<PostsEntity>) {
        posts.clear()
        posts.addAll(items)
        notifyDataSetChanged()
    }

}