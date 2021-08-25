package com.konet.konetpos.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("data") val data: LoginData,
    @SerializedName("refresh_token") val refreshToken: String
) : Parcelable

@Parcelize
data class LoginData(
    @SerializedName("user") val user: UserDetails,
) : Parcelable

@Parcelize
data class UserDetails(
    @SerializedName("id") val id: String,
    @SerializedName("token") val token: String,
    @SerializedName("email") val email: String,
    @SerializedName("fullname") val fullname: String,
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