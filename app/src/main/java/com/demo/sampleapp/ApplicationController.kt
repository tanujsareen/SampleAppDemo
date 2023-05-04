package com.demo.sampleapp

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import com.demo.sampleapp.common.FakeCrashLibrary
import com.glowingbit.ashdesigns.common.InternetUtil
import timber.log.Timber

class ApplicationController: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }

        InternetUtil.init(this)
    }


    init {
        instance = this
    }

    companion object {
        private var instance: ApplicationController? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, @NonNull message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }

            FakeCrashLibrary.log(priority, tag, message)

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t)
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t)
                }
            }
        }
    }
}