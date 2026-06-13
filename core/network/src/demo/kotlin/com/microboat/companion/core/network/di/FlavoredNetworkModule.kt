/*
 * Copyright 2022 microboat. All rights reserved.
 */
package com.microboat.companion.core.network.di

import com.microboat.companion.core.network.AppNetworkDataSource
import com.microboat.companion.core.network.demo.DemoNiaNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface FlavoredNetworkModule {

    @Binds
    fun binds(impl: DemoNiaNetworkDataSource): AppNetworkDataSource
}
