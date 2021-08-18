package com.konet.konetpos

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.konetpaypos.base.BaseActivity
import com.konet.konetpos.databinding.ActivityMainBinding
import com.konet.konetpos.purchase.Purchase
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : BaseActivity<MainActivityViewModel>(), MainActivityView {
    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        view.purchaseBtn.setOnClickListener {
            val intent = Intent(this, Purchase::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
            finish()
        }
    }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun getViewModel(): MainActivityViewModel =mainActivityViewModel

    override fun getBindingVariable(): Int {
        TODO("Not yet implemented")
    }

    override fun initView() {
    }

    override fun logout() {
    }

    override fun screenBack() {
    }


}