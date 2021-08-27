package com.konet.konetpos.utils

import android.content.Intent
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


class AppUtils {

    fun getJsonMap(resultData: Intent, dataval: String): Map<String, Any> {
        var map: Map<String, Any> = HashMap()
        map = Gson().fromJson(resultData.getStringExtra(dataval).toString(), map.javaClass)
        return map;
    }

    fun SnackbarFailed(viewDataBinding: View, mess: String) {
        Snackbar.make(viewDataBinding, mess, Snackbar.LENGTH_SHORT).show();

    }

}