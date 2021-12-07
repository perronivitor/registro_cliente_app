package com.perroni.registroclienteapp.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.perroni.registroclienteapp.domain.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM table_user")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM table_user where cpf")
    fun getUser(cpf : String):LiveData<UserEntity>

    @Insert
    suspend fun insert(userEntity: UserEntity): Long

    @Update
    suspend fun update (userEntity : UserEntity)

    @Delete
    suspend fun delete(id : Long)





}