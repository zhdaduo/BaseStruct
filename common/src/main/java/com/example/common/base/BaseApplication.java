package com.example.common.base;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.di.GlobalAppComponent;

/**
 * Created by Bill on 2017/8/1.
 */

public class BaseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    GlobalAppComponent.init(this);
    ARouter.init(this);
  }
}
