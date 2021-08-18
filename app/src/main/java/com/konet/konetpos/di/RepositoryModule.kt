package com.konet.konetpos.di

import com.konet.konetpos.domain.repository.AuthRepository
import com.konet.konetpos.network.remote.ApiHelper
import com.konet.konetpos.network.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthenticateRepository(apiHelper: ApiHelper): AuthRepository {
        return AuthRepositoryImpl(apiHelper)
    }


}