package com.konet.konetpos.ui.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


open class BaseViewModel<V> : ViewModel() {

    private var view: WeakReference<V>? = null

    fun getView(): V? {
        return this.view?.get()
    }

    fun setView(view: V) {
        this.view = WeakReference(view)
    }
}