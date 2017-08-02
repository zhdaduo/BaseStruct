package com.example.bill.basestruct.MVP;

import com.example.common.di.ActivityScope;
import com.example.common.di.AppComponent;
import dagger.Component;

/**
 * Created by Bill on 2017/8/1.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {MainModule.class})
public interface MainComponent {

  void inject(MainActivity activity);
}
