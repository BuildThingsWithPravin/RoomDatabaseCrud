package com.example.demohilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.demohilt.api.ApiService
import com.example.demohilt.api.AppModule
import com.example.demohilt.data.NetworkClass
import com.example.demohilt.data.PassengerModel
import com.example.demohilt.data.UserModel
import com.example.demohilt.extra.createLog
import com.example.demohilt.extra.emitResponse
import com.example.demohilt.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: UserRepo,
    private val apiService: ApiService,
) : ViewModel() {

    private val _userData = MutableLiveData<NetworkClass<UserModel>>()
    val userData: LiveData<NetworkClass<UserModel>>
        get() = _userData

    fun getUser(email: String, password: String, rememberMe: Boolean) {
        _userData.value = NetworkClass.Loading()
        viewModelScope.launch {
            _userData.value = repo.loginUser(email, password, rememberMe).emitResponse()
        }
    }

    private val _userDatas = MutableLiveData<NetworkClass<String>>()
    val userDatas: LiveData<NetworkClass<String>>
        get() = _userDatas

    fun getUsers(email: String) {
        _userDatas.value = NetworkClass.Loading()
        viewModelScope.launch {
            _userDatas.value = repo.sendVarificationCode(email).emitResponse()
        }
    }

    private val _passengerResponse = MutableLiveData<NetworkClass<PassengerModel>>()
    val passengerResponse: LiveData<NetworkClass<PassengerModel>>
        get() = _passengerResponse

    fun getPassengerList(
        page: Int,
        size: Int,
    ) {
        _passengerResponse.value = NetworkClass.Loading()
        viewModelScope.launch {
            _passengerResponse.value = repo.getPassenger(page, size).emitResponse()
        }
    }

/*
    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        ExamplePagingSource(apiService, 2)
    }.flow
        .cachedIn(viewModelScope)
*/


}


