package com.fangga.bfaa.githubuserapp.presentation.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import com.fangga.bfaa.githubuserapp.R
import com.fangga.bfaa.githubuserapp.model.User

class MainViewModel {

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
                listOfUsername[position],
                listOfName[position],
                listOfLocation[position],
                listOfRepository[position],
                listOfCompany[position],
                listOfFollower[position],
                listOfFollowing[position],
                listOfAvatar.getResourceId(position,0)
            )

            listOfUsers.add(user)
        }
        return listOfUsers
    }

}