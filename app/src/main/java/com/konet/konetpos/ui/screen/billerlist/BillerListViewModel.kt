package com.konet.konetpos.ui.screen.billerlist

import androidx.lifecycle.viewModelScope
import com.konet.konetpos.ui.base.BaseViewModel
import com.konet.konetpos.utils.HawkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BillerListViewModel @Inject constructor( hawkHelper: HawkHelper):
    BaseViewModel<BillerListView>(){

    val accountBalance: String=hawkHelper.getUserDetail()!!.wallet.available_balance+":00"
    fun getMyCards() {
        viewModelScope.launch {
//            handleGetMyCards(getMyCardUseCase.execute(request))
        }
    }
}