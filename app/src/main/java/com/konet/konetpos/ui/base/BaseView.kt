package com.konet.konetpos.ui.base

interface BaseView {
    fun handleError(error: Throwable, option: Any? = null)
    fun screenBack()
    fun showProgressDialog(isShow: Boolean)
    fun showSnackBar(message: String)
    fun showSnackBar(resId: Int)
}