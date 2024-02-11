package dev.ctsetera.sample02.application

import android.app.Application

class LogApplication : Application() {
    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator(applicationContext)
    }
}