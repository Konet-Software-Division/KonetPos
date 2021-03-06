package com.konet.konetpos.network.remote


import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.BillerCategoriesResponse
import com.konet.konetpos.network.response.BillerListResponse
import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.response.WalletDetailsResponse

import retrofit2.Response
import retrofit2.http.*

interface API {

    /***************** Authentication *****************/
    @POST("users_service/api/v1/auth/login")
    suspend fun signIn(@Body request: LoginRequest): Response<LoginResponse>

    @GET("wallet_service/api/v1/wallets")
    suspend fun walletDetails(): Response<WalletDetailsResponse>

    @GET("wallet_service/api/v1/billers/categories")
    suspend fun billerCategories(): Response<BillerCategoriesResponse>

    @PATCH("/wallet_service/api/v1/billers/{CATEGORY_ID}/list")
    suspend fun billerList(@Path("CATEGORY_ID") id: Int?): Response<BillerListResponse>

}

