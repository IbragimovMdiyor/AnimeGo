package com.example.animego

import android.app.Application
import com.example.animego.presentation.di.dataModule
import com.example.animego.presentation.di.domainModule
import com.example.animego.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }
    }
}