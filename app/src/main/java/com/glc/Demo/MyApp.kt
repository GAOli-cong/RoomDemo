package com.glc.Demo

import android.app.Application
import android.content.Context

/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
class MyApp :Application(){
    companion object{
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}