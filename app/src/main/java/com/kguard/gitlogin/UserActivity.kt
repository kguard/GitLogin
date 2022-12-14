package com.kguard.gitlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.kguard.gitlogin.base.BaseActivity
import com.kguard.gitlogin.databinding.ActivityMainBinding
import com.kguard.gitlogin.databinding.ActivityUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity :  BaseActivity<ActivityUserBinding>(R.layout.activity_user){
    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val token= intent.getStringExtra("token").toString()
        viewModel.getUser(token)
        Log.e("===", "onCreate: $token", )
        viewModel.user.observe(this){
            binding.username.text=it.username
            binding.name.text=it.name
            binding.email.text=it.email
            binding.bio.text=it.bio
            binding.location.text=it.location
            binding.following.text=it.following.toString()
            binding.follower.text=it.followers.toString()
        }
        binding.repo.setOnClickListener{
            val intent = Intent(applicationContext,RepoActivity::class.java)
            intent.putExtra("token",token)
            startActivity(intent)
        }
    }




}