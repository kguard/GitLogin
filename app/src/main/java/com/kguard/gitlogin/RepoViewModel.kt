package com.kguard.gitlogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kguard.domain.DomainRepo
import com.kguard.domain.DomainUser
import com.kguard.gitlogin.usecase.RepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RepoViewModel @Inject constructor(
    private val repoUseCase: RepoUseCase
):ViewModel(){
    private val _repo = MutableStateFlow<List<DomainRepo>>(emptyList())
    val repo : StateFlow<List<DomainRepo>>
        get() = _repo

    fun getRepo(token :String)
    {
        viewModelScope.launch {
            _repo.value=repoUseCase.getRepo("bearer $token")
        }
    }
}