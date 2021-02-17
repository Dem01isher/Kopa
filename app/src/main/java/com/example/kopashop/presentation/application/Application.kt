package com.example.kopashop.presentation.application

import android.app.Application
import com.example.kopashop.di.remoteDataSourceModule
import com.example.kopashop.di.repositoriesModule
import com.example.kopashop.di.viewModelsModule
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin{
            androidContext(this@Application)
            androidLogger()
            modules(
                remoteDataSourceModule,
                repositoriesModule,
                viewModelsModule
            )
        }

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}