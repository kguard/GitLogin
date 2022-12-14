package com.kguard.gitlogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kguard.domain.DomainAccessToken
import com.kguard.gitlogin.usecase.RepoUseCase
import com.kguard.gitlogin.usecase.TokenUseCase
import com.kguard.gitlogin.usecase.UserUseCase
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
            _accessToken.value = tokenUseCase.getToken(BuildConfig.CLIENT_ID,BuildConfig.CLIENT_SECRET,code)

        }
    }
}