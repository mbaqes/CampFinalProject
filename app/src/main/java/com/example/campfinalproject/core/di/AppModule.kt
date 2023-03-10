package com.example.campfinalproject.core.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.campfinalproject.core.api.DummyServer
import com.example.campfinalproject.core.authintactionstor.AuthintactionStor
import com.example.campfinalproject.core.authintactionstor.AuthintactionStorImpl
import com.example.campfinalproject.core.constins.Constins
import com.example.campfinalproject.pages.homepage.data.repository.ProductRepository
import com.example.campfinalproject.pages.homepage.data.repository.ProductRepositoryImp
import com.example.campfinalproject.pages.loginpage.data.repository.LoginRepository
import com.example.campfinalproject.pages.loginpage.data.repository.LoginRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesServer():DummyServer{
        return Retrofit.Builder().baseUrl(Constins.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DummyServer::class.java)
    }
    @Singleton
    @Provides
    fun providesSharedPreferences(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences(Constins.SHAERDPREFERENCES,MODE_PRIVATE)
    }
    @Singleton
    @Provides
    fun providesAuthintactionStor(sharedPreferences: SharedPreferences): AuthintactionStor {
        return AuthintactionStorImpl(sharedPreferences)
    }
    @Singleton
    @Provides
    fun providesRepository(dummyServer: DummyServer,authintactionStor: AuthintactionStor):ProductRepository{
        return ProductRepositoryImp(dummyServer,authintactionStor)
    }
    @Singleton
    @Provides
    fun providesLoginRepository(dummyServer: DummyServer,authintactionStor: AuthintactionStor):LoginRepository{
        return LoginRepositoryImp(authintactionStor,dummyServer)
    }

}