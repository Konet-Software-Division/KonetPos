package com.konet.konetpos.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class WalletDetailsResponse(
    @SerializedName("wallet") val wallet: WalletDetails
) : Parcelable

@Parcelize
data class WalletDetails(
    @SerializedName("id") val data: String
) : Parcelable