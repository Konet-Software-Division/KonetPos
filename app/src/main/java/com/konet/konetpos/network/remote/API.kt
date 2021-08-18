package com.konet.konetpos.network.remote


import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface API {

    /***************** Authentication *****************/
    @POST("token")
    suspend fun signIn(@Body request: LoginRequest): Response<LoginResponse>


}

