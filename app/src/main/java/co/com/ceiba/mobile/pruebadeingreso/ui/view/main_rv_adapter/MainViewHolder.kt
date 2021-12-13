package co.com.ceiba.mobile.pruebadeingreso.ui.view.main_rv_adapter

import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.data.db.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.databinding.UserListItemBinding

class MainViewHolder(val itemBinding: UserListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(item: UserEntity) {
        itemBinding.apply {
            name.text = item.name
            phone.text = item.phone
            email.text = item.email
        }
    }

}