package ru.skillbranch.gameofthrones

import android.app.Application
import android.content.Context

class App: Application() {
    companion object {
        lateinit var appCtx: Context
        fun applicationContext() = appCtx
    }

    override fun onCreate() {
        super.onCreate()
        appCtx = applicationContext
    }
}
