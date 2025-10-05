package com.omaradev.di

import com.omaradev.data.remote.PostApi
import com.omaradev.data.repository.PostRepositoryImpl
import com.omaradev.domain.repository.PostRepository
import com.omaradev.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/") // example API
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): PostApi =
        retrofit.create(PostApi::class.java)

    @Provides
    @Singleton
    fun providePostRepository(api: PostApi): PostRepository =
        PostRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetPostsUseCase(repository: PostRepository): GetPostsUseCase =
        GetPostsUseCase(repository)
}