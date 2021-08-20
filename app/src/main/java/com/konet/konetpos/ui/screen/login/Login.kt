package com.konet.konetpos.ui.screen.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.konet.konetpos.BR
import com.konet.konetpos.R
import com.konet.konetpos.ui.screen.base.BaseActivity
import com.konet.konetpos.databinding.LoginBinding


class Login : BaseActivity<LoginBinding, LoginViewModel>(), LoginView {
    private lateinit var binding: LoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    override fun getBindingVariable():Int = BR.viewModel;
    override fun getViewModel(): LoginViewModel = loginViewModel
    override fun getLayoutId() = R.layout.login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)
    }

    var UserDetailsActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
//            Log.i("utility", data!!.getStringExtra("data").toString())
        }
    }

    fun ContinuePayment(amount: String) {
        val jsonString = "{ \"transType\": \"PURCHASE\", \"amount\":\"$amount\",\"print\":\"true\" }"
        val intent = Intent("com.globalaccelerex.transaction")
        intent.putExtra("requestData", jsonString)

       PaymentActivitys.launch(intent)
    }

    var PaymentActivitys = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
//            Log.i("rrrrsd", data!!.getStringExtra("data").toString())
        }
    }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        TODO("Not yet implemented")
    }

    override fun initView() {
        //            val intent = Intent("com.globalaccelerex.utility")
//           UserDetailsActivity.launch(intent)
//        binding = LoginBinding.inflate(layoutInflater)
//
//        binding.continueBtn.setOnClickListener {
//            ContinuePayment(binding.amountEdt.text.toString());
//        }
    }

    override fun screenBack() {
    }


}