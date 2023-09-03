package ru.sr.testtaskhotel

import android.app.Application
import org.koin.core.context.startKoin
import ru.sr.storage.di.apiModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                apiModule()
            )
        }
    }
}