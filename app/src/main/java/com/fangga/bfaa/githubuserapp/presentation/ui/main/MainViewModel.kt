package com.fangga.bfaa.githubuserapp.presentation.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import androidx.lifecycle.ViewModel
import com.fangga.bfaa.githubuserapp.R
import com.fangga.bfaa.githubuserapp.model.User

class MainViewModel: ViewModel() {

    @SuppressLint("Recycle")
    fun getUsersData(context: Context): ArrayList<User> {

        val listOfUsername: Array<String> = context.resources.getStringArray(R.array.username)
        val listOfName: Array<String> = context.resources.getStringArray(R.array.name)
        val listOfLocation: Array<String> = context.resources.getStringArray(R.array.location)
        val listOfRepository: Array<String> = context.resources.getStringArray(R.array.repository)
        val listOfCompany: Array<String> = context.resources.getStringArray(R.array.company)
        val listOfFollower: Array<String> = context.resources.getStringArray(R.array.followers)
        val listOfFollowing: Array<String> = context.resources.getStringArray(R.array.following)
        val listOfAvatar: TypedArray = context.resources.obtainTypedArray(R.array.avatar)

        val listOfUsers = ArrayList<User>()

        for (position in listOfUsername.indices){
            val user = User(
                username = listOfUsername[position],
                name = listOfName[position],
                location = listOfLocation[position],
                repository = listOfRepository[position],
                company = listOfCompany[position],
                follower = listOfFollower[position],
                following = listOfFollowing[position],
                avatar = listOfAvatar.getResourceId(position,0)
            )

            listOfUsers.add(user)
        }
        return listOfUsers
    }

}