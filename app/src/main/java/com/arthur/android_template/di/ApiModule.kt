package com.arthur.android_template.di

import com.arthur.android_template.data.remote.api.LoginApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

}