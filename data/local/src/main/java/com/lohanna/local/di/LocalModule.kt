package com.lohanna.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.lohanna.data.source.MatchesDataSource
import com.lohanna.local.source.MatchDataSourceLocal
import dagger.Binds
import dagger.Module
import dagger.Provides

private const val PREFERENCES_NAME = "notifications_prefs"

@Module
interface LocalModule {
    @Binds
    fun providesMatchDataSourceLocal(impl: MatchDataSourceLocal): MatchesDataSource.Local

    companion object {
        private val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

        @Provides
        fun providesDataStore(context: Context): DataStore<Preferences> =
            context.dataStore
    }
}