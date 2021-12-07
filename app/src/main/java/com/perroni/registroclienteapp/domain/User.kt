package com.perroni.registroclienteapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String,
    val matricula: String,
    val cpf: String,
    val email: String,
) : Parcelable

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        name = name,
        matricula = matricula,
        cpf = cpf,
        email = email,
        )
}