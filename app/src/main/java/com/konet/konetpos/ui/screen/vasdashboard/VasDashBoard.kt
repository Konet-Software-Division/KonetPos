package com.konet.konetpos.ui.screen.vasdashboard

import android.os.Bundle
import androidx.activity.viewModels
import com.konet.konetpos.BR
import com.konet.konetpos.R
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.databinding.VasbashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VasDashBoard : BaseActivity<VasbashboardBinding, VasDashBoardViewModel>(), VasDashBoardView {

    private lateinit var binding: VasbashboardBinding
    private val vasDashBoardViewModel: VasDashBoardViewModel by viewModels()
    override fun getViewModel(): VasDashBoardViewModel = vasDashBoardViewModel
    override fun getLayoutId() = R.layout.vasbashboard
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