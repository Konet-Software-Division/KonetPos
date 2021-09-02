package com.konet.konetpos.domain.repository

import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.BillerCategoriesResponse
import com.konet.konetpos.network.response.BillerListResponse
import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.response.WalletDetailsResponse


interface AuthRepository {

    suspend fun signIn(request: LoginRequest): LoginResponse

    suspend fun billerCategories(): BillerCategoriesResponse

    suspend fun billerList(catId:Int): BillerListResponse

    suspend fun getAccountDetails(): WalletDetailsResponse

}