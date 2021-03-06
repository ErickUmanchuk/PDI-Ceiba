package co.com.ceiba.mobile.pruebadeingreso.ui.view.main_rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.databinding.UserListItemBinding

open class MainAdapter(var users: MutableList<UserEntity>, private val listener: ClickListener) :
    RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(
            UserListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(users[position])
        holder.itemBinding.btnViewPost.setOnClickListener { listener.OnClick(users[position]) }
    }

    override fun getItemCount() = users.size

    fun setItems(items: List<UserEntity>) {
        users.clear()
        users.addAll(items)
        notifyDataSetChanged()
    }

    fun filterList(filteredUsers: MutableList<UserEntity>) {
        this.users.clear()
        this.users = filteredUsers
        notifyDataSetChanged()
    }

}