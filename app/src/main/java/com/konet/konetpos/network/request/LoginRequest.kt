package com.konet.konetpos.network.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("phone") val phone: String,
    @SerializedName("pin") val pin: String,
    @SerializedName("device") val device: String
) : Parcelable