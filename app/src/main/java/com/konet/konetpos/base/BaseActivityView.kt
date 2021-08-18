package com.example.konetpaypos.base


interface BaseActivityView {
    fun showProgressDialog(isShow: Boolean)
    fun showSnackBar(resId: Int)
    fun showSnackBar(message: String)
    fun handleError(error: Throwable, option: Any? = null)
}