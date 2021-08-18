package com.konet.konetpos.purchase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.konetpaypos.base.BaseActivity
import com.konet.konetpos.databinding.PurchaseAmountBinding
import kotlinx.android.synthetic.main.purchase_amount.view.*


class Purchase : BaseActivity<PurchaseViewModel>(), PurchaseView {
    private lateinit var binding: PurchaseAmountBinding
    private val purchaseViewModel: PurchaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PurchaseAmountBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
            val intent = Intent("com.globalaccelerex.utility")
           UserDetailsActivity.launch(intent)

        view.continue_btn.setOnClickListener {
            ContinuePayment(view.amount_Edt.text.toString());
        }
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

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun getViewModel(): PurchaseViewModel = purchaseViewModel

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