package com.kguard.gitlogin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kguard.gitlogin.base.BaseFragment
import com.kguard.gitlogin.databinding.FragmentLogInBinding

class LogInFragment : BaseFragment<FragmentLogInBinding>(R.layout.fragment_log_in) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    fun login()
    {
        val loginUrl = Uri.Builder().scheme("https").authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter("client_id",BuildConfig.CLIENT)
            .build()

    }



}