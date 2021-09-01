package com.konet.konetpos.ui.screen.purchase

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.widget.RxTextView
import com.konet.konetpos.*
import com.konet.konetpos.databinding.ActivityMainBinding
import com.konet.konetpos.databinding.PurchaseBinding
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.utils.AppUtils
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable

@AndroidEntryPoint
class Purchase : BaseActivity<PurchaseBinding, PurchaseViewModel>(), PurchaseView {


    private var isValid: Boolean = false
    private val purchaseViewModel: PurchaseViewModel by viewModels()
    override fun getBindingVariable(): Int = BR.viewModel;
    override fun getViewModel(): PurchaseViewModel = purchaseViewModel
    override fun getLayoutId() = R.layout.purchase

    lateinit var terminalID:String

//    var JSaa: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)

    }
//
//    var UserDetailsActivity =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val data: Intent? = result.data
//                MerchantName =
//                    AppUtils().getJsonMap(result.data!!, "data").get("MerchantName").toString();
//
//            }
//        }

//    var SettingsActivity =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val data: Intent? = result.data
//                MerchantName =
//                    AppUtils().getJsonMap(result.data!!, "data").get("MerchantName").toString();
//
//            }
//        }

    fun ContinuePayment(amount: String) {
        if (amount.toInt() < 1) {
            AppUtils().SnackbarFailed(viewDataBinding.root, "Amount must be more than 0")
            return
        }
        val jsonString =
            "{ \"transType\": \"PURCHASE\", \"amount\":\"$amount\",\"print\":\"true\" }"
        try {
            val intent = Intent("com.globalaccelerex.transaction")
            intent.putExtra("requestData", jsonString)
            PaymentActivitys.launch(intent)
        } catch (e: Exception) {

            Log.i("ErrorPaymentActivitys", e.message.toString())
        }

    }

    var PaymentActivitys =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                try {
                    if (result.data!!.hasExtra("data")) {
                        val MapData = AppUtils().getJsonMap(result.data!!, "data");
                        Log.i("fgfdhf",AppUtils().getJsonMap(result.data!!, "data").toString())
                        terminalID=MapData.get("terminalID").toString()
                        if (MapData.get("statuscode").toString().contentEquals("00")) {
                          val  JSaa = "{\n" +
                                    "    \"Receipt\": [\n" +
                                    "        {\n" +
                                    "            \"Bitmap\": \"${R.drawable.launcher}\",\n" +
                                    "            \"letterSpacing\": 5,\n" +
                                    "            \"String\": [\n" +
                                    "                {\n" +
                                    "                    \"isMultiline\": false,\n" +
                                    "                    \"header\": {\n" +
                                    "                        \"text\": \"Merchant Name\",\n" +
                                    "                        \"align\": \"le\",\n" +
                                    "                        \"size\": \"large\",\n" +
                                    "                        \"isBold\": true\n" +
                                    "                    },\n" +
                                    "                    \"body\": {\n" +
                                    "                        \"text\": \"Konetpay\",\n" +
                                    "                        \"alignment\": \"centre\",\n" +
                                    "                        \"size\": \"normal\",\n" +
                                    "                        \"isBold\": false\n" +
                                    "                    }\n" +
                                    "                },\n" +
                                    "                {\n" +
                                    "                    \"isMultiline\": false,\n" +
                                    "                    \"header\": {\n" +
                                    "                        \"text\": \"Reference Number\",\n" +
                                    "                        \"align\": \"left\",\n" +
                                    "                        \"size\": \"large\",\n" +
                                    "                        \"isBold\": true\n" +
                                    "                    },\n" +
                                    "                    \"body\": {\n" +
                                    "                        \"text\": \"${MapData.get("rrn").toString()}\",\n" +
                                    "                        \"alignment\": \"centre\",\n" +
                                    "                        \"size\": \"normal\",\n" +
                                    "                        \"isBold\": false\n" +
                                    "                    }\n" +
                                    "                },\n" +
                                    "                {\n" +
                                    "                    \"isMultiline\": false,\n" +
                                    "                    \"header\": {\n" +
                                    "                        \"text\": \"Amount\",\n" +
                                    "                        \"align\": \"left\",\n" +
                                    "                        \"size\": \"large\",\n" +
                                    "                        \"isBold\": true\n" +
                                    "                    },\n" +
                                    "                    \"body\": {\n" +
                                    "                        \"text\": \"${MapData.get("amount").toString()}\",\n" +
                                    "                        \"alignment\": \"centre\",\n" +
                                    "                        \"size\": \"large\",\n" +
                                    "                        \"isBold\": false\n" +
                                    "                    }\n" +
                                    "                }\n" +
                                    "            ]\n" +
                                    "        }\n" +
                                    "    ]\n" +
                                    "}"

//                            Log.i("utilityppppp", JSaa)

                            val intent = Intent("com.globalaccelerex.printer")
                            intent.putExtra("jsonData", JSaa)
                            PrintActivitys.launch(intent)

                        } else {
                            Snackbar.make(
                                viewDataBinding.root,
                                MapData.get("message").toString().toString(),
                                Snackbar.LENGTH_LONG
                            ).show()

                        }
                    }
                } catch (e: Exception) {
                    Log.i("PurchasePaymentsDAta", e.message.toString())
                }
            }
        }

    var PrintActivitys =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
                Snackbar.make(
                    viewDataBinding.root,
                    "Transaction successful",
                    Snackbar.LENGTH_LONG
                ).show()
//                val data: Intent? = result.data
//                SettingsActivity.launch(Intent("com.globalaccelerex.settings"))
//                MerchantName =
//                    AppUtils().getJsonMap(result.data!!, "data").get("MerchantName").toString();
//                Log.i("utilityyy", MerchantName)

            }
        }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        TODO("Not yet implemented")
    }

    override fun initView() {
//        try {
//            val intent = Intent("com.globalaccelerex.utility")
//            UserDetailsActivity.launch(intent)
//        } catch (e: Exception) {
//            Log.i("ErrorUserDetailsActivit",e.message.toString())
//        }
        viewDataBinding.continueBtn.setOnClickListener {
            ContinuePayment(viewDataBinding.amountEdt.text.toString());
        }
        validateButtonPurchase()

    }

    override fun screenBack() {
    }

    @SuppressLint("CheckResult")
    private fun validateButtonPurchase() {
        try {
            val amountEdtObservable = RxTextView.textChanges(viewDataBinding.amountEdt)
            val amountEdtObservabl = RxTextView.textChanges(viewDataBinding.amountEdt)
            val isSignInEnabled: Observable<Boolean> = Observable.combineLatest(
                amountEdtObservable, amountEdtObservabl,
                { amount, am ->
                    amount.isNotEmpty()
                })

            isSignInEnabled.subscribe {
                isValid = it
                if (it && viewDataBinding.amountEdt.text.toString().toInt()>0) {
                    viewDataBinding.continueBtn.background =
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.rounded_button_selector
                        )
                } else {
                    viewDataBinding.continueBtn.background =
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.button_round_light_blue
                        )
                }
            }
        } catch (e: Exception) {
        }
    }


}