package com.lego.mydiablo

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.lego.mydiablo.di.appModule
import com.lego.mydiablo.tools.crashreporting.CrashlyticsReportingTree
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import io.fabric.sdk.android.Fabric
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.android.startKoin
import org.koin.core.Koin
import org.koin.log.EmptyLogger
import timber.log.Timber

class DiabloApplication : Application() {

    companion object {
        lateinit var instance: DiabloApplication

        fun getRefWatcher(context: Context): RefWatcher = instance.refWatcher

        fun applicationContext(): Context = instance.applicationContext

    }

    private lateinit var refWatcher: RefWatcher

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        initKoin()
        JodaTimeAndroid.init(this)
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        refWatcher = LeakCanary.install(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Fabric.with(this, Crashlytics())
            Timber.plant(CrashlyticsReportingTree())
        }
    }

    private fun initKoin() {
        startKoin(this, appModule)
        Koin.logger = EmptyLogger()
    }

}