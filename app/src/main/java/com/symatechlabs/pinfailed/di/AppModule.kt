package com.symatechlabs.pinfailed.di

import android.content.Context
import com.symatechlabs.pinfailed.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: App): Context = app;

    @Singleton
    @Provides
    fun provideBaseApplicationContext(@ApplicationContext app: Context): App {
        return  app as App;
    }


}