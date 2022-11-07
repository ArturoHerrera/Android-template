package com.arthur.android_template.di

import com.arthur.android_template.data.repository.login_repository.repositorys.LoginGoodRepository
import com.arthur.android_template.data.repository.login_repository.repositorys.LoginTasks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class InterfaceTasksModule {

    @Binds
    abstract fun bindsCategoryListTasks(
        repository: LoginGoodRepository
    ): LoginTasks

}