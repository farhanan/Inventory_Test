package com.farhan.test.data.di

import com.farhan.test.data.remote.api.ApiCallback
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    fun provideDefaultApiCallback(retrofit: Retrofit): ApiCallback =
            retrofit.create(ApiCallback::class.java)
}