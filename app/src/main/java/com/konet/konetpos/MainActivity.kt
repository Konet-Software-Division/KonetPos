package com.konet.konetpos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.databinding.ActivityMainBinding
import com.konet.konetpos.ui.screen.login.Login
import com.konet.konetpos.ui.screen.purchase.Purchase
import com.konet.konetpos.ui.screen.vasdashboard.VasDashBoard
import com.konet.konetpos.utils.HawkHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(), MainActivityView,
    CoroutineScope {

    @Inject
    lateinit var hawkHelper: HawkHelper

    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun getBindingVariable():Int = BR.viewModel;
    override fun getViewModel(): MainActivityViewModel = mainActivityViewModel
    override fun getLayoutId() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)
    }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        TODO("Not yet implemented")
    }


    override fun initView() {
        viewDataBinding.purchaseBtn.setOnClickListener {
            val intent = Intent(this, Purchase::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }
//        viewDataBinding.vasBtn.visibility=View.GONE
        viewDataBinding.vasBtn.setOnClickListener {
            if (hawkHelper.getLoggedin()) {
                val intent = Intent(this, VasDashBoard::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)

            } else {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
            }

        }
    }

    override fun screenBack() {
        TODO("Not yet implemented")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


}