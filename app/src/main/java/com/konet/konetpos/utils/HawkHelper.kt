package com.konet.konetpos.utils

import com.konet.konetpos.network.response.WalletDetailsResponse
import com.orhanobut.hawk.Hawk

class HawkHelper {

    companion object {
        private const val LOGGEDIN = "loggedin"
        private const val TOKEN = "token"
        private const val USER_DETAIL = "user_detail"
    }

    fun getLoggedin(): Boolean {
        return Hawk.get(LOGGEDIN, false)
    }

    fun setLoggedin(loggedin: Boolean) {
        Hawk.put(LOGGEDIN, loggedin)
    }

    fun getToken(): String {
        return Hawk.get(TOKEN, "")
    }

    fun setToken(token: String) {
        Hawk.put(TOKEN, "Bearer $token")
    }

    fun getUserDetail(): WalletDetailsResponse? {
        return Hawk.get(USER_DETAIL)
    }

    fun setUserDetail(walletDetailsResponse: WalletDetailsResponse) {
        Hawk.put(USER_DETAIL, walletDetailsResponse)
    }

    fun clearAll() {
        Hawk.deleteAll()
    }

}