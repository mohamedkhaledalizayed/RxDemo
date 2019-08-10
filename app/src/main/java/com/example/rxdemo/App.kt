package com.example.rxdemo

import com.example.rxdemo.Constants.CUSTOM_NO_DATA
import com.example.rxdemo.Constants.CUSTOM_NO_INTERNET
import com.tripl3dev.prettystates.StatesConfigFactory
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        StatesConfigFactory.Companion.intialize()
            .initDefaultViews()
        StatesConfigFactory.Companion.get().addStateView(Constants.CUSTOM_ERROR,R.layout.custom_height_error)
        StatesConfigFactory.Companion.get().addStateView(CUSTOM_NO_DATA,R.layout.custom_no_data_found)
        StatesConfigFactory.Companion.get().addStateView(CUSTOM_NO_INTERNET,R.layout.custom_no_internet)

    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}