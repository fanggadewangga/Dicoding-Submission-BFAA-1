package com.fangga.bfaa.githubuserapp.presentation.ui.detail

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fangga.bfaa.githubuserapp.base.BaseActivity
import com.fangga.bfaa.githubuserapp.databinding.ActivityDetailBinding
import com.fangga.bfaa.githubuserapp.model.User
import com.fangga.bfaa.githubuserapp.util.Constant.EXTRA_USER
import com.fangga.bfaa.githubuserapp.util.ScreenOrientation

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun determineScreenOrientation(): ScreenOrientation {
        return ScreenOrientation.PORTRAIT
    }

    override fun ActivityDetailBinding.binder() {
        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        tvUsername.text = user?.username
        tvName.text = user?.name
        tvFollowerValue.text = user?.follower
        tvFollowingValue.text = user?.following
        tvCompanyValue.text = user?.company
        tvLocationValue.text = user?.location
        tvRepositoryValue.text = user?.repository

        Glide.with(this@DetailActivity)
            .load(user?.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(ivUserAvatar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = user?.username
            elevation = 0f
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}