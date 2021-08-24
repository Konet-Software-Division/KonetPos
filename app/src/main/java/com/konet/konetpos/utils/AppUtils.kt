package com.konet.konetpos.utils

import android.content.Intent
import com.google.gson.Gson


class AppUtils {



    @Suppress("SameParameterValue")
    public fun getJsonMap(resultData: Intent, dataval: String): Map<String, Any> {
        var map: Map<String, Any> = HashMap()
        map = Gson().fromJson(resultData.getStringExtra(dataval).toString(), map.javaClass)
        return map;
    }
}