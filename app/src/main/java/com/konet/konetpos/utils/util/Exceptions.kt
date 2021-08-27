package com.konet.konetpos.utils.util

import retrofit2.HttpException
import retrofit2.Response

class ApiException(message: Response<Any>) : HttpException(message)
