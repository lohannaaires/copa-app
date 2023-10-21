package com.lohanna.copaapp.di

import android.app.Application
import android.content.Context
import com.lohanna.data.di.DataModule
import com.lohanna.local.di.LocalModule
import com.lohanna.remote.di.NetworkModule
import com.lohanna.remote.di.RemoteModule
import com.lohanna.remote.di.ServiceModules
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DataModule::class,
        LocalModule::class,
        RemoteModule::class,
        NetworkModule::class,
        ServiceModules::class,
    ]
)
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}
