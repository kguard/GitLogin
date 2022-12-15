package com.kguard.gitlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.kguard.gitlogin.base.BaseActivity
import com.kguard.gitlogin.databinding.ActivityRepoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
@AndroidEntryPoint
class RepoActivity : BaseActivity<ActivityRepoBinding>(R.layout.activity_repo){
    private val viewModel: RepoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val token= intent?.getStringExtra("token").toString()
        viewModel.getRepo(token)
        val adapter = RepoAdapter()
        binding.lifecycleOwner?.lifecycleScope?.launchWhenResumed {
            viewModel.repo.collectLatest {
                adapter.submitList(it)
            }
        }
        binding.recyclerview.adapter=adapter
    }


}