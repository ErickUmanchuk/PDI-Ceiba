package co.com.ceiba.mobile.pruebadeingreso.ui.view.posts.posts_rv_adapter

import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.PostsEntity
import co.com.ceiba.mobile.pruebadeingreso.databinding.PostListItemBinding

class PostViewHolder(val itemBinding: PostListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(item: PostsEntity) {
        itemBinding.apply {
            title.text = item.title
            body.text = item.body
        }
    }

}