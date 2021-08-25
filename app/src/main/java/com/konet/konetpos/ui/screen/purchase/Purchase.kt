package com.konet.konetpos.ui.screen.purchase

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.widget.RxTextView
import com.konet.konetpos.*
import com.konet.konetpos.databinding.PurchaseBinding
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.utils.AppUtils
import io.reactivex.Observable


class Purchase : BaseActivity<PurchaseBinding, PurchaseViewModel>(), PurchaseView {
    private var isOn: Boolean = false
    private var isValid: Boolean = false
    private lateinit var binding: PurchaseBinding
    private val purchaseViewModel: PurchaseViewModel by viewModels()
    override fun getBindingVariable(): Int = BR.viewModel;
    override fun getViewModel(): PurchaseViewModel = purchaseViewModel
    override fun getLayoutId() = R.layout.purchase
    var MerchantName: String = ""

    var JSaa="{\n" +
            "    \"Receipt\": [{\n" +
            "    \"Bitmap\": \"filename\",\n" +
            "    \"letterSpacing\": 5,\n" +
            "    \"String\": [{\n" +
            "    \"isMultiline\": true,\n" +
            "    \"header\": {\n" +
            "    \"text\": \"Merchant Name\",\n" +
            "    \"align\": \"centre\",\n" +
            "    \"size\": \"large\",\n" +
            "    \"isBold\": true\n" +
            "}, \"body\": {\n" +
            "    \"text\": \"Global Accelerex\",\n" +
            "    \"alignment\": \"centre\",\n" +
            "    \"size\": \"normal\",\n" +
            "    \"isBold\": false\n" +
            "} },\n" +
            "    {\n" +
            "        \"isMultiline\": false,\n" +
            "        \"header\": {\n" +
            "        \"text\": \"Reference Number\",\n" +
            "        \"align\": \"left\",\n" +
            "        \"size\": \"large\",\n" +
            "        \"isBold\": true\n" +
            "    }, \"body\": {\n" +
            "        \"text\": \"123456789\"\n" +
            "    }\n" +
            "    } ]\n" +
            "}, {\n" +
            "    \"Bitmap\": \"filename\",\n" +
            "    \"letterSpacing\": 5,\n" +
            "    \"String\": [{\n" +
            "    \"isMultiline\": true,\n" +
            "    \"header\": {\n" +
            "    \"text\": \"Merchant Name\",\n" +
            "    \"align\": \"centre\",\n" +
            "    \"size\": \"large\",\n" +
            "    \"isBold\": true\n" +
            "}, \"body\": {\n" +
            "    \"text\": \"Allen Tobi\",\n" +
            "    \"alignment\": \"centre\",\n" +
            "    \"size\": \"normal\",\n" +
            "    \"isBold\": false\n" +
            "} },\n" +
            "    {\n" +
            "        \"isMultiline\": false,\n" +
            "        \"header\": {\n" +
            "        \"text\": \"Reference Number\",\n" +
            "        \"align\": \"left\",\n" +
            "        \"size\": \"large\",\n" +
            "        \"isBold\": true\n" +
            "    }, \"body\": {\n" +
            "        \"text\": \"abcd1234\"\n" +
            "    }\n" +
            "    } ]\n" +
            "} ]\n" +
            "}\n" +
            "        "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)
    }

    var UserDetailsActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                MerchantName =
                    AppUtils().getJsonMap(result.data!!, "data").get("MerchantName").toString();

            }
        }

    var SettingsActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                MerchantName =
                    AppUtils().getJsonMap(result.data!!, "data").get("MerchantName").toString();

            }
        }

    fun ContinuePayment(amount: String) {
        val jsonString =
            "{ \"transType\": \"PURCHASE\", \"amount\":\"$amount\",\"print\":\"true\" }"
        val intent = Intent("com.globalaccelerex.transaction")
        intent.putExtra("requestData", jsonString)

        PaymentActivitys.launch(intent)
    }

    var PaymentActivitys =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val MapData = AppUtils().getJsonMap(result.data!!, "data");

                if (MapData.get("statuscode").toString().contentEquals("00")) {
                    val Merchantheader =
                        TextField(MerchantName, align = "centre", size = "large", isBold = true)
                    val Merchantbody = TextField(
                        text = "Global Accelerex",
                        align = "right",
                        size = "normal",
                        isBold = true
                    )

                    val ReferenceNumberheader =
                        TextField(MerchantName, align = "centre", size = "large", isBold = true)
                    val ReferenceNumberbody = TextField(
                        text = "Reference Number",
                        align = "right",
                        size = "normal",
                        isBold = false
                    )

                    val stringField = listOf(
                        StringField(true, Merchantheader, Merchantbody),
                        StringField(true, ReferenceNumberheader, ReferenceNumberbody)
                    )
                    val printField = listOf(PrintField("filename", 5, stringField))
                    val buyGiftcardRequest = PrintObject(
                        printFields = printField
                    )

                    val jsonString = buyGiftcardRequest.toString()

                    Snackbar.make(
                        viewDataBinding.root,
                        "Yes print",
                        Snackbar.LENGTH_LONG
                    ).show()
//                    Log.i("utilityppppp", jsonString)
//                    Log.i("utilityppppp", JSaa)

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
        }

    var PrintActivitys =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
                Snackbar.make(
                    binding.root,
                    "Transaction successful",
                    Snackbar.LENGTH_LONG
                ).show()
                val data: Intent? = result.data
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
        val intent = Intent("com.globalaccelerex.utility")
        UserDetailsActivity.launch(intent)


        viewDataBinding.continueBtn.setOnClickListener {
            ContinuePayment(viewDataBinding.amountEdt.text.toString());
        }
        validateButtonLogin()
    }

    override fun screenBack() {
    }

    @SuppressLint("CheckResult")
    private fun validateButtonLogin() {
        val amountEdtObservable = RxTextView.textChanges(viewDataBinding.amountEdt)
        val amountEdtObservabl = RxTextView.textChanges(viewDataBinding.amountEdt)
        val isSignInEnabled: Observable<Boolean> = Observable.combineLatest(
            amountEdtObservable,amountEdtObservabl,
            { amount,am ->
                amount.isNotEmpty()
            })

        isSignInEnabled.subscribe {
            isValid = it
            if (it) {
                viewDataBinding.continueBtn.background =
                    ContextCompat.getDrawable(applicationContext, R.drawable.rounded_button_selector)
            } else {
                viewDataBinding.continueBtn.background =
                    ContextCompat.getDrawable(applicationContext, R.drawable.button_round_light_blue)
            }
        }
    }


}