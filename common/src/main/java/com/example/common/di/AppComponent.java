package com.example.common.di;

import dagger.Component;
import javax.inject.Singleton;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import retrofit2.Retrofit;

/**
 * Created by Bill on 2017/8/1.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

  Retrofit getRetrofit();

  RxErrorHandler getRxErrorHandler();
}
