package com.lohanna.data.di

import com.lohanna.data.repository.MatchesRepositoryImpl
import com.lohanna.domain.repositories.MatchesRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun providesMatchesRepository(impl: MatchesRepositoryImpl): MatchesRepository
}
