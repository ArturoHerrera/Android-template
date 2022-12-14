package com.arthur.android_template.di

import com.arthur.android_template.core.AppDatabase
import com.arthur.android_template.core.AppPreferences
import com.arthur.android_template.data.remote.api.LoginApi
import com.arthur.android_template.data.repository.login_repository.local_data_sources.LoginRoomLocalDataSource
import com.arthur.android_template.data.repository.login_repository.remote_data_sources.LoginRetrofitRemoteDataSource
import com.arthur.android_template.data.repository.login_repository.repositorys.LoginGoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesLoginGoodRepository(
        api: LoginApi,
        db: AppDatabase,
        prefs: AppPreferences
    ): LoginGoodRepository = LoginGoodRepository(
        loginLocalDS = LoginRoomLocalDataSource(
            pref = prefs,
            dao = db.userDao()
        ),
        loginRemoteDS = LoginRetrofitRemoteDataSource(
            loginApi = api
        )
    )

}