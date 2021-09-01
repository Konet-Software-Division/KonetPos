package com.konet.konetpos.ui.screen.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.widget.RxTextView
import com.konet.konetpos.BR
import com.konet.konetpos.R
import com.konet.konetpos.common.ErrorHandler
import com.konet.konetpos.ui.base.BaseActivity
import com.konet.konetpos.databinding.LoginBinding
import com.konet.konetpos.ui.screen.vasdashboard.VasDashBoard
import com.konet.konetpos.utils.AppUtils
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import javax.inject.Inject

@AndroidEntryPoint

class Login : BaseActivity<LoginBinding, LoginViewModel>(), LoginView {

    private var isValid: Boolean = false

    private val loginViewModel: LoginViewModel by viewModels()
    override fun getBindingVariable():Int = BR.viewModel;
    override fun getViewModel(): LoginViewModel = loginViewModel
    override fun getLayoutId() = R.layout.login

    @Inject
    lateinit var errorHandler: ErrorHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setView(this)
        validateButtonLogin()
    }

    @SuppressLint("CheckResult")
    private fun validateButtonLogin() {
        val phoneEdObservable = RxTextView.textChanges(viewDataBinding.phoneEdt)
        val pinObservable = RxTextView.textChanges(viewDataBinding.pinEdt)
        val isSignInEnabled: Observable<Boolean> = Observable.combineLatest(
            phoneEdObservable,
            pinObservable,
            { phone, pin ->
                phone.isNotEmpty() && pin.isNotEmpty()
            })

        isSignInEnabled.subscribe {
            isValid = it
            if (it) {
                viewDataBinding.loginBtn.background =
                    ContextCompat.getDrawable(applicationContext, R.drawable.rounded_button_selector)
            } else {
                viewDataBinding.loginBtn.background =
                    ContextCompat.getDrawable(applicationContext, R.drawable.button_round_light_blue)
            }
        }
    }

    override fun onErrorAfterDialogDismiss(error: Throwable, option: Any?) {
        Log.i("dddddd",error.message.toString())
    }

    override fun initView() {
        viewDataBinding.phoneEdt.setText("08044444444")
        viewDataBinding.pinEdt.setText("123456")

        viewDataBinding.loginBtn.setOnClickListener {
            if (isValid) {
                loginViewModel.doLogin(
                    phone = viewDataBinding.phoneEdt.text.toString(),
                    pin = viewDataBinding.pinEdt.text.toString(),
                    device = viewDataBinding.phoneEdt.text.toString()
                )
            }
        }
    }

    override fun loginSuccess() {
        val intent = Intent(this, VasDashBoard::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        finish()
    }

    override fun loginFailed(mess: String) {
        AppUtils().SnackbarFailed(viewDataBinding.root, mess)
    }

    override fun screenBack() {
        TODO("Not yet implemented")
    }


}