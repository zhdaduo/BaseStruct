package com.example.bill.basestruct.MVP;

import com.example.bill.basestruct.model.api.UserService;
import com.example.common.di.ActivityScope;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Bill on 2017/8/1.
 */
@Module
public class MainModule {

  private MainContract.View mView;

  public MainModule(MainContract.View view) {
    mView = view;
  }

  @ActivityScope
  @Provides
  UserService provideSiteService(Retrofit retrofit) {
    return retrofit.create(UserService.class);
  }

  @ActivityScope
  @Provides
  MainContract.View provideView() {
    return mView;
  }

  @ActivityScope
  @Provides
  MainContract.Model provideModel(MainModel model) {
    return model;
  }
}
