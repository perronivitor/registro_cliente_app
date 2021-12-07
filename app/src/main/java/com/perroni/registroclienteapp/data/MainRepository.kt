package com.perroni.registroclienteapp.data

import androidx.lifecycle.LiveData
import com.perroni.registroclienteapp.data.db.UserDao
import com.perroni.registroclienteapp.domain.User
import com.perroni.registroclienteapp.domain.UserEntity
import com.perroni.registroclienteapp.domain.toUserEntity

class MainRepository (private val userDao : UserDao) {

     suspend fun insertUser(user: User): Long {
       return userDao.insert(user.toUserEntity())
    }

     suspend fun updateUser(userEntity: UserEntity) {
       userDao.update(userEntity)
    }

    suspend fun deleteUser(id: Long) {
        userDao.delete(id)
    }

    fun getUser(cpf : String): LiveData<UserEntity> {
        return  userDao.getUser(cpf)
    }

     fun getAllUsers(): LiveData<List<UserEntity>> {
       return userDao.getAll()
    }

}