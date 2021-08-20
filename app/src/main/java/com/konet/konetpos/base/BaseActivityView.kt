package com.konet.konetpos.base


interface BaseActivityView {
    fun showProgressDialog(isShow: Boolean)
    fun showSnackBar(resId: Int)
    fun showSnackBar(message: String)
    fun handleError(error: Throwable, option: Any? = null)
}