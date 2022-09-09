package com.fangga.bfaa.githubuserapp.presentation.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.fangga.bfaa.githubuserapp.base.BaseActivity
import com.fangga.bfaa.githubuserapp.databinding.ActivityMainBinding
import com.fangga.bfaa.githubuserapp.presentation.adapter.UserAdapter
import com.fangga.bfaa.githubuserapp.util.ScreenOrientation

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel = MainViewModel()

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun determineScreenOrientation(): ScreenOrientation {
        return ScreenOrientation.PORTRAIT
    }

    override fun ActivityMainBinding.binder() {
        val rvAdapter = UserAdapter()
        val listOfUsers = viewModel.getUsersData(this@MainActivity)

        rvListUser.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        rvAdapter.submitData(listOfUsers)
    }
}