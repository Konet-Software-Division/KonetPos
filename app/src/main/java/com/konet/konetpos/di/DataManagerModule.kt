package com.konet.konetpos.di


import com.konet.konetpos.network.remote.API
import com.konet.konetpos.network.remote.ApiHelper
import com.konet.konetpos.network.remote.ApiHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataManagerModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper {
        return apiHelperImpl
    }
}