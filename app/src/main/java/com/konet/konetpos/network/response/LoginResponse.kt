package com.konet.konetpos.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("data") val data: LoginData,
    @SerializedName("refresh_token") val refreshToken: String
) : Parcelable

@Parcelize
data class LoginData(
    @SerializedName("code") val code: Int,
    @SerializedName("token") val token: String
) : Parcelable

//
//@Parcelize
//data class ProfileResponse(
//    @SerializedName("data") val data: DataDetails
//) : Parcelable
//
//@Parcelize
//data class DataDetails(
//    @SerializedName("user") val user: UserDetails
//) : Parcelable
//
//@Parcelize
//data class UserDetails(
//    @SerializedName("user") val user: String
//) : Parcelable