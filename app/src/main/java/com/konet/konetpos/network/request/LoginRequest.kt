package com.konet.konetpos.network.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String
) : Parcelable