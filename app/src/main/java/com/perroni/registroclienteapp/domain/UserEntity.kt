package com.perroni.registroclienteapp.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "matricula") val matricula: String,
    @ColumnInfo(name = "cpf") val cpf: String,
    @ColumnInfo(name = "email") val email: String,
)