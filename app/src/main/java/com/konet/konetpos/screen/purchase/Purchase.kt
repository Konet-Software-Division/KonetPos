package com.konet.konetpos.screen.purchase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.konet.konetpos.BR
import com.konet.konetpos.R
import com.konet.konetpos.base.BaseActivity
import com.konet.konetpos.databinding.PurchaseAmountBinding


class Purchase : BaseActivity<PurchaseAmountBinding,PurchaseViewModel>(), PurchaseView {
    private lateinit var binding: PurchaseAmountBinding
    private val purchaseViewModel: PurchaseViewModel by viewModels()
    override fun getBindingVariable():Int = BR.viewModel;
    override fun getViewModel(): PurchaseViewModel = purchaseViewModel
    override fun getLayoutId() = R.layout.purchase_amount

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
        binding = PurchaseAmountBinding.inflate(layoutInflater)

        binding.continueBtn.setOnClickListener {
            ContinuePayment(binding.amountEdt.text.toString());
        }
    }

    override fun screenBack() {
    }


}