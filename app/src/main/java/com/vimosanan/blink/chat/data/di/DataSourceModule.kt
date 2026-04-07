package com.vimosanan.blink.chat.data.di

import com.vimosanan.blink.chat.data.local.datasource.ChatLocalDataSource
import com.vimosanan.blink.chat.data.local.datasource.ChatLocalDataSourceImpl
import com.vimosanan.blink.chat.data.remote.datasource.ChatRemoteDataSource
import com.vimosanan.blink.chat.data.remote.datasource.ChatRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindChatLocalDataSource(
        chatLocalDataSourceImpl: ChatLocalDataSourceImpl
    ): ChatLocalDataSource

    @Binds
    @Singleton
    abstract fun bindChatRemoteDataSource(
        chatRemoteDataSourceImpl: ChatRemoteDataSourceImpl
    ): ChatRemoteDataSource
}