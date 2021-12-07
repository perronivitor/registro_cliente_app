package com.perroni.registroclienteapp.presentation.add_adit

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.perroni.registroclienteapp.R
import com.perroni.registroclienteapp.data.AppDataBase
import com.perroni.registroclienteapp.data.MainRepository
import com.perroni.registroclienteapp.domain.User
import kotlinx.coroutines.launch

class AddViewModel(private var repository: MainRepository) : ViewModel() {

    var error = MutableLiveData<String>()
    var success = MutableLiveData<String>()

    var fieldError = MutableLiveData<Int>()

    fun verifyFieldName(text: String) : Boolean{
        if(text.isEmpty()) {
            return false
        }
        if (text.trim().split(" ").size <= 1){

            return false
        }
        return true
    }

    fun verifyFieldMatricula(){

    }

    fun addUser(user: User) = viewModelScope.launch {
        try {
            val id = repository.insertUser(user)
            if (id > 0) {
                success.value = R.string.usuario_inserido_sucesso.toString()
            }
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    companion object {
        private val TAG = AddViewModel::class.java.simpleName
    }

    /**
     * FACTORY
     */
    class AddViewModelFactory constructor(private val application: Application) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
                return  return AddViewModel(
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