package com.fangga.bfaa.githubuserapp.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fangga.bfaa.githubuserapp.base.BaseRecyclerViewAdapter
import com.fangga.bfaa.githubuserapp.databinding.ItemListUserBinding
import com.fangga.bfaa.githubuserapp.model.User
import com.fangga.bfaa.githubuserapp.presentation.diff_callback.UserDiffUtil
import com.fangga.bfaa.githubuserapp.presentation.ui.detail.DetailActivity
import com.fangga.bfaa.githubuserapp.util.Constant.EXTRA_USER

class UserAdapter: BaseRecyclerViewAdapter<ItemListUserBinding, User>() {
    override fun inflateViewBinding(parent: ViewGroup): ItemListUserBinding =
        ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override val binder: (User, ItemListUserBinding) -> Unit = { data, binding ->
        binding.apply {
            tvUsername.text = data.username
            tvName.text = data.name
            tvLocation.text = data.location

            Glide.with(itemView!!.context)
                .load(data.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.ivUserAvatar)

            itemView!!.setOnClickListener{
                val intent = Intent(itemView!!.context, DetailActivity::class.java)
                intent.putExtra(EXTRA_USER,data)
                itemView!!.context.startActivity(intent)
            }
        }
    }

    override val diffUtilBuilder: (List<User>, List<User>) -> DiffUtil.Callback = { old, new ->
        UserDiffUtil(old, new)
    }

}