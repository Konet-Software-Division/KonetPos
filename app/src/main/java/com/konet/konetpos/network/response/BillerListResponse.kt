package com.konet.konetpos.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class BillerListResponse(
    @SerializedName("billers") val wallet: Billers
) : Parcelable

@Parcelize
data class Billers(
    @SerializedName("currencyCode") val currencyCode: String,
    @SerializedName("currencySymbol") val currencySymbol: String,
    @SerializedName("customerField1") val customerField1: String,
    @SerializedName("name") val name: String

) : Parcelable