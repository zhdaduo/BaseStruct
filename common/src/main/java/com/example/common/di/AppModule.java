package com.example.common.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErroListener;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bill on 2017/8/1.
 */
@Module
public class AppModule {

  private final Context application;
  private String mBaseUrl;

  public AppModule(Context application, String mBaseUrl) {
    this.application = application;
    this.mBaseUrl = mBaseUrl;
  }

  @Singleton
  @Provides
  RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
    return RxJavaCallAdapterFactory.create();
  }

  @Singleton
  @Provides
  GsonConverterFactory provideGsonConverterFactory() {
    GsonConverterFactory factory = GsonConverterFactory.create();
    return factory;
  }

  @Singleton
  @Provides
  OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build();
  }

  @Singleton
  @Provides
  Retrofit provideRetrofit(OkHttpClient client,
      GsonConverterFactory converterFactory, RxJavaCallAdapterFactory adapterFactory) {
    return new Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(adapterFactory)
        .client(client)
        .build();
  }

  @Provides
  @Singleton
  Context provideApplication() {
    return application;
  }

  @Singleton
  @Provides
  RxErrorHandler provideRxErrorHandler(ResponseErroListener listener) {
    return RxErrorHandler
        .builder()
        .with(application)
        .responseErroListener(listener)
        .build();
  }

  @Singleton
  @Provides
  ResponseErroListener provideResponseErrorListener() {
    return ResponseErroListener.EMPTY;
  }
}
