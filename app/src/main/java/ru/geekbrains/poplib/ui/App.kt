package ru.geekbrains.poplib.ui

import android.app.Application
import ru.geekbrains.poplib.mvp.model.rxbus.RxBus
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router


class App : Application() {
    companion object {
        lateinit var instance: App
    }

    private var bus: RxBus? = null

    val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        bus = RxBus()
    }


    fun bus(): RxBus? {
        return bus
    }
    fun getNavigatorHolder() = cicerone.navigatorHolder
    fun getRouter() = cicerone.router
}