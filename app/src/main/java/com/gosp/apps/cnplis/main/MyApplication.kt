package com.gosp.apps.cnplis.main

import androidx.lifecycle.LifecycleObserver
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: LifecycleObserver, MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }
}
