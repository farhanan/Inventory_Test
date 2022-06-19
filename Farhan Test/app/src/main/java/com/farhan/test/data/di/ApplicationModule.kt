package com.farhan.test.data.di

import android.app.Application
import android.content.Context
import com.farhan.test.data.local.dao.OrderDao
import com.farhan.test.data.local.dao.StockDao
import com.farhan.test.data.local.preferences.AccessManager
import com.farhan.test.data.remote.api.ApiCallback
import com.farhan.test.data.repository.OrderRepository
import com.farhan.test.data.repository.StockRepository
import com.farhan.test.data.source.OrderLocalDataSource
import com.farhan.test.data.source.StockLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Provides
    fun provideApplication(application: Application): Context = application

    @Provides
    fun provideAccessManager(context: Context) = AccessManager(context)


    @Provides
    fun provideOrderRepository(
       orderDao: OrderDao
    ) = OrderRepository(
        OrderLocalDataSource(orderDao)
    )

    @Provides
    fun provideStockRepository(
       stockDao: StockDao
    ) = StockRepository(
        StockLocalDataSource(stockDao)
    )

}