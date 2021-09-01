package com.konet.konetpos.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class BillerCategoriesResponse(
    @SerializedName("categories") val wallet: Categories
) : Parcelable

@Parcelize
data class Categories(
    @SerializedName("categoryId") val categoryId: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String

) : Parcelable