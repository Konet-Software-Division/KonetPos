package com.konet.konetpos.ui.screen.billerlist

import android.os.Bundle
import androidx.activity.viewModels
import com.konet.konetpos.BR
import com.konet.konetpos.R
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.databinding.BillerlistBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BillerList : BaseActivity<BillerlistBinding, BillerListViewModel>(), BillerListView {

    private val billerListViewModel: BillerListViewModel by viewModels()
    override fun getViewModel(): BillerListViewModel = billerListViewModel
    override fun getLayoutId() = R.layout.billerlist
    override fun getBindingVariable():Int = BR.viewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)


    }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        TODO("Not yet implemented")
    }


    override fun initView() {

    }

    override fun screenBack() {
    }


}