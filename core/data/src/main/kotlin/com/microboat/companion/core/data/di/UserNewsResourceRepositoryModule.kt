/*
 * Copyright 2023 microboat. All rights reserved.
 */
package com.microboat.companion.core.data.di

import com.microboat.companion.core.data.repository.CompositeUserNewsResourceRepository
import com.microboat.companion.core.data.repository.UserNewsResourceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface UserNewsResourceRepositoryModule {
    @Binds
    fun bindsUserNewsResourceRepository(
        userDataRepository: CompositeUserNewsResourceRepository,
    ): UserNewsResourceRepository
}
