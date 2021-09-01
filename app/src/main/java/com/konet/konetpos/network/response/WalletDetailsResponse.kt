package com.konet.konetpos.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class WalletDetailsResponse(
    @SerializedName("wallet") val wallet: WalletDetails
) : Parcelable

@Parcelize
data class WalletDetails(
    @SerializedName("user") val user: String,
    @SerializedName("available_balance") val available_balance: String

) : Parcelable