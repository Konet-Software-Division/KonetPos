package com.konet.konetpos.screen.vasdashboard

import android.os.Bundle
import androidx.activity.viewModels
import com.konet.konetpos.BR
import com.konet.konetpos.R
import com.konet.konetpos.base.BaseActivity
import com.konet.konetpos.databinding.VasbashboardBinding


class VasDashBoard : BaseActivity<VasbashboardBinding,VasDashBoardViewModel>(), VasDashBoardView {
    private lateinit var binding: VasbashboardBinding
    private val vasDashBoardViewModel: VasDashBoardViewModel by viewModels()
    override fun getViewModel(): VasDashBoardViewModel = vasDashBoardViewModel
    override fun getLayoutId() = R.layout.login
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