package com.lohanna.remote.di

import com.lohanna.data.source.MatchesDataSource
import com.lohanna.remote.source.MatchDataSourceRemote
import dagger.Binds
import dagger.Module

@Module
interface RemoteModule {

    @Binds
    fun providesMatchDataSourceRemote(impl: MatchDataSourceRemote): MatchesDataSource.Remote
}