package com.kguard.gitlogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kguard.domain.DomainAccessToken
import com.kguard.domain.DomainUser
import com.kguard.gitlogin.usecase.RepoUseCase
import com.kguard.gitlogin.usecase.TokenUseCase
import com.kguard.gitlogin.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(
    private val repoUseCase: RepoUseCase,
    private val tokenUseCase: TokenUseCase,
    private val userUseCase: UserUseCase
): ViewModel() {
    private val _user = MutableLiveData<DomainUser>()
    val user : MutableLiveData<DomainUser>
        get() = _user

    fun getUser(token: String) {
        viewModelScope.launch {
            user.value=userUseCase.getUser("bearer $token")
        }

    }

}