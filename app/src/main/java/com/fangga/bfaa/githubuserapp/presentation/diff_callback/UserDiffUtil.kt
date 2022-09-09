package com.fangga.bfaa.githubuserapp.presentation.diff_callback

import com.fangga.bfaa.githubuserapp.base.BaseDiffUtil
import com.fangga.bfaa.githubuserapp.model.User

class UserDiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>
): BaseDiffUtil<User, String>(oldList,newList) {
    override fun User.getItemIdentifier(): String = this.username
}