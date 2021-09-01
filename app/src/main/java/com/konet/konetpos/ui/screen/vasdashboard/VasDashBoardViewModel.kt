package com.konet.konetpos.ui.screen.vasdashboard

import com.konet.konetpos.ui.base.BaseViewModel
import com.konet.konetpos.utils.HawkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


@HiltViewModel
class VasDashBoardViewModel @Inject constructor( hawkHelper: HawkHelper):
    BaseViewModel<VasDashBoardView>(){

    val accountBalance: String=hawkHelper.getUserDetail()!!.wallet.available_balance+":00"
    fun getMyCards() {
        viewModelScope.launch {
//            handleGetMyCards(getMyCardUseCase.execute(request))
        }
    }
}