package com.konet.konetpos.ui.screen.vasdashboard

import com.konet.konetpos.ui.base.BaseViewModel
import com.konet.konetpos.utils.HawkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import androidx.lifecycle.viewModelScope
import com.konet.konetpos.domain.usecase.BillCategoryUseCase
import kotlinx.coroutines.launch
import timber.log.Timber


@HiltViewModel
class VasDashBoardViewModel @Inject constructor(
    private val billCategoryUseCase: BillCategoryUseCase,
    hawkHelper: HawkHelper):
    BaseViewModel<VasDashBoardView>(){

    val accountBalance: String=hawkHelper.getUserDetail()!!.wallet.available_balance+":00"
    fun getMyCards() {
        viewModelScope.launch {
            handleGetBillCategories(billCategoryUseCase.execute())
        }
    }

    private fun handleGetBillCategories(result: BillCategoryUseCase.Result) {
        when (result) {
            is BillCategoryUseCase.Result.Loading -> {
                getView()?.showProgressDialog(true)
            }
            is BillCategoryUseCase.Result.Success -> {
                getView()?.showProgressDialog(false)
//                getView()?.sendMyGiftCardSuccess(result.response.message + " to " + result.response.data.friendName)
            }
            is BillCategoryUseCase.Result.Failure -> {
                Timber.e(result.throwable)
                getView()?.showProgressDialog(false)
                getView()?.handleError(result.throwable)
            }
        }
    }
}