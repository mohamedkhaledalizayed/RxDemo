package com.example.rxdemo

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun  provideRetrofitInstance(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/posts")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMainApi(retrofit: Retrofit): ServicesApi {
        return retrofit.create(ServicesApi::class.java)
    }
}