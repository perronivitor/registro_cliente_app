package com.perroni.registroclienteapp.presentation.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.perroni.registroclienteapp.data.AppDataBase
import com.perroni.registroclienteapp.data.MainRepository
import kotlinx.coroutines.launch

class HomeViewModel(private var repository: MainRepository) : ViewModel() {

    var error = MutableLiveData<String>()
    var success = MutableLiveData<String>()

    var getAllUsers = repository.getAllUsers()

    fun removeUser(id : Long) = viewModelScope.launch {
        try {
            repository.deleteUser(id)
            getAllUsers.value?.forEach { user ->
                if (user.id == id){
                    getAllUsers = repository.getAllUsers()
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }

    /**
     * FACTORY
     */
    class HomeViewModelFactory constructor(private val application: Application) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(
                    repository = MainRepository(
                        userDao = AppDataBase
                            .getInstance(application.applicationContext).userDao
                    )
                ) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }

}