package com.perroni.registroclienteapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.perroni.registroclienteapp.data.db.UserDao
import com.perroni.registroclienteapp.domain.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract val userDao : UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "user_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}