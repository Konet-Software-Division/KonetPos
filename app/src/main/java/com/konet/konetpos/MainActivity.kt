package com.konet.konetpos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.databinding.ActivityMainBinding
import com.konet.konetpos.ui.screen.purchase.Purchase
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(), MainActivityView {

    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun getBindingVariable():Int = BR.viewModel;
    override fun getViewModel(): MainActivityViewModel =mainActivityViewModel
    override fun getLayoutId() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)
    }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        TODO("Not yet implemented")
    }


    override fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.purchaseBtn.setOnClickListener {
            val intent = Intent(this, Purchase::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }
        binding.vasBtn.visibility= View.GONE
        binding.vasBtn.setOnClickListener {
//            if (hawkHelper.getLoggedin()) {
//                val intent = Intent(this, VasDashBoard::class.java)
//                startActivity(intent)
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
//
//            } else {
//                val intent = Intent(this, Login::class.java)
//                startActivity(intent)
//                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
//            }

        }
    }

    override fun screenBack() {
        TODO("Not yet implemented")
    }


}