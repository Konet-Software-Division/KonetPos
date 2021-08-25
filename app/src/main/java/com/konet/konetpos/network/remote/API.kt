package com.konet.konetpos.network.remote


import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.response.WalletDetailsResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    /***************** Authentication *****************/
    @POST("users_service/api/v1/auth/login")
    suspend fun signIn(@Body request: LoginRequest): Response<LoginResponse>

    @GET("token")
    suspend fun walletDetails(): Response<WalletDetailsResponse>


}

