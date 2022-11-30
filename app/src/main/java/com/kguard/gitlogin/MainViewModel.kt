package com.kguard.gitlogin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kguard.domain.DomainAccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repoUseCase: RepoUseCase,
    private val tokenUseCase: TokenUseCase,
    private val userUseCase: UserUseCase
):ViewModel() {
    private val _accessToken = MutableLiveData<DomainAccessToken>()
    val accessToken : MutableLiveData<DomainAccessToken>
    get() = _accessToken

    fun getAccessToken(code:String) {
        viewModelScope.launch {
            Log.e("---", "getAccessToken: ${code}")
            _accessToken.value = tokenUseCase.getToken(BuildConfig.CLIENT_ID,BuildConfig.CLIENT_SECRET,code)

        }
    }
}