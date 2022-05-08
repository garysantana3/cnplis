package com.gosp.apps.cnplis.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private fun initInterceptor(): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor()
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(240, TimeUnit.SECONDS)
        httpClient.readTimeout(240, TimeUnit.SECONDS)
        httpClient.writeTimeout(240, TimeUnit.SECONDS)

        httpClient.addInterceptor(headerInterceptor())

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpClient.addInterceptor(logging)
    }

    private fun headerInterceptor (): Interceptor {
        val headerAuthorizationInterceptor = Interceptor { chain ->

            var request: Request = chain.request()
            val headers = request.headers.newBuilder()
                .add("api_key", Endpoints.HEADER_API_KEY)
                .build()
            request = request.newBuilder().headers(headers).build()
            chain.proceed(request)

        }
        return headerAuthorizationInterceptor
    }

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(initInterceptor().build())
            .build()
    }

    @Singleton
    @Provides
    fun providerApiClient(retrofit: Retrofit) : CineApiClient {
        return retrofit.create(CineApiClient::class.java)
    }
}