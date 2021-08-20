package com.konet.konetpos

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.konet.konetpos.base.BaseActivity
import com.konet.konetpos.databinding.ActivityMainBinding
import com.konet.konetpos.screen.login.Login
import com.konet.konetpos.screen.purchase.Purchase
import com.konet.konetpos.screen.vasdashboard.VasDashBoard


class MainActivity : BaseActivity<ActivityMainBinding,MainActivityViewModel>(), MainActivityView {
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
        binding.vasBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }
    }


    override fun screenBack() {
    }


}