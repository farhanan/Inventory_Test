package com.farhan.test.data.di

import android.content.Context
import androidx.room.Room
import com.farhan.test.data.local.EDatabase
import com.farhan.test.util.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
            Room.databaseBuilder(
                context,
                EDatabase::class.java,
                Const.Database.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

    @Singleton
    @Provides
    fun provideOrderDao(database: EDatabase) = database.orderDao()

    @Singleton
    @Provides
    fun provideStockDao(database: EDatabase) = database.stockDao()

}