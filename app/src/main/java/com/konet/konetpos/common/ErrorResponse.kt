package com.konet.konetpos.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ErrorResponse(
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("status") val status: String?

) : Parcelable