package com.astrapay.androidsdksamples

import android.annotation.SuppressLint
import com.astrapay.qrissdk.AstraPaySdkApplication
import com.astrapay.qrissdk.helper.AstraPayQris

class ClientApplication : AstraPaySdkApplication() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate() {
        super.onCreate()
        AstraPayQris.setup("XTOKEN", AstraPayQris.Build.SIT)
    }
}