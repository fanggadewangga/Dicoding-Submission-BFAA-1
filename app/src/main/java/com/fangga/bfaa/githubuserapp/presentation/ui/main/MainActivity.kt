package com.fangga.bfaa.githubuserapp.presentation.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fangga.bfaa.githubuserapp.base.BaseActivity
import com.fangga.bfaa.githubuserapp.databinding.ActivityMainBinding
import com.fangga.bfaa.githubuserapp.presentation.adapter.UserAdapter
import com.fangga.bfaa.githubuserapp.util.ScreenOrientation

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var viewModel: MainViewModel

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun determineScreenOrientation(): ScreenOrientation {
        return ScreenOrientation.PORTRAIT
    }

    override fun ActivityMainBinding.binder() {
        viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

        val rvAdapter = UserAdapter()
        val listOfUsers = viewModel.getUsersData(this@MainActivity)

        rvListUser.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        rvAdapter.submitData(listOfUsers)

        supportActionBar?.apply {
            title = "Github User App"
            elevation=1f
        }
    }
}