package com.example.common.di;

import static com.example.common.util.ConfigConstant.BaseUrl;

import android.content.Context;

/**
 * Created by Bill on 2017/8/1.
 */

public class GlobalAppComponent {

  private volatile static AppComponent mAppComponent;

  public static void init(Context context){
    if(mAppComponent == null){
      synchronized (GlobalAppComponent.class){
        if(mAppComponent == null){
          mAppComponent = DaggerAppComponent.builder()
              .appModule(new AppModule(context.getApplicationContext(), BaseUrl))
              .build();
        }
      }
    }
  }

  public static AppComponent getAppComponent() {
    if(mAppComponent == null){
      throw (new NullPointerException("GlobalAppComponent必须在application中进行init初始化"));
    }
    return mAppComponent;
  }
}
