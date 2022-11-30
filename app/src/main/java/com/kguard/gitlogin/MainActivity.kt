package com.kguard.gitlogin

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.kguard.gitlogin.base.BaseActivity
import com.kguard.gitlogin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var navController: NavController
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
//        navController = navHostFragment.navController
        binding.button2.setOnClickListener{ login() }
        viewModel.accessToken.observe(this){
            Log.e("---", "onCreate: ${it}", )
            binding.textView.text= it.toString()
        }
    }

    private fun login()
    {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
            "${BuildConfig.BASE_URL}?client_id=${BuildConfig.CLIENT_ID}"))
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val uri = intent.data

        Log.e("----", "onResume: $uri " )
        if(uri != null){
            val code =uri?.getQueryParameter("code")
            Log.e("---", "onResume: $code")
            if(code!=null)
            {
                viewModel.getAccessToken(code)
            }
            else {
                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }
        }

    }

}