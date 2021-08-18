package com.konet.konetpos.custom

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.konet.konetpos.R

class GiftOgaProgressDialog(context: Context) : Dialog(context, R.style.transparent_progress_dialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading_progress)
        setCancelable(true)
        setCanceledOnTouchOutside(true)
    }
}