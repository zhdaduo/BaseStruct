package com.example.bill.basestruct.MVP;

import com.example.bill.basestruct.model.api.UserService;
import com.example.bill.basestruct.model.bean.Token;
import com.example.common.di.ActivityScope;
import com.example.common.util.RetrofitConstant;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Bill on 2017/8/1.
 */
@ActivityScope
public class MainModel implements MainContract.Model {

  @Inject
  public MainModel() {
  }

  @Inject
  UserService service;

  @Override
  public void onDestroy() {

  }

  @Override
  public Observable<Token> getToken(String username, String password) {
    return service.getToken(RetrofitConstant.VALUE_CLIENT_ID, RetrofitConstant.VALUE_CLIENT_SECRET, RetrofitConstant.VALUE_GRANT_TYPE_PASSWORD, username, password);

  }
}
