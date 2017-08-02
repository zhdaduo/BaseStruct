package com.example.bill.basestruct.MVP;

import android.support.annotation.NonNull;
import com.example.bill.basestruct.MVP.MainContract.Model;
import com.example.bill.basestruct.MVP.MainContract.View;
import com.example.bill.basestruct.model.bean.Token;
import com.example.common.base.BasePresenter;
import com.example.common.di.ActivityScope;
import com.example.common.util.NoNetworkException;
import com.example.common.util.RxUtil;
import javax.inject.Inject;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

/**
 * Created by Bill on 2017/8/1.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<Model, View> {

  private MainContract.Model model;
  private MainContract.View view;
  private RxErrorHandler mErrorHandler;

  @Inject
  public MainPresenter(MainContract.Model model, MainContract.View view, RxErrorHandler handler) {
    this.model = model;
    this.view = view;
    this.mErrorHandler = handler;
  }

  public void getToken(String username, String password) {
    model.getToken(username, password)
        .compose(RxUtil.applySchedulers(view))
        .compose(RxUtil.bindToLifecycle(view))
        .subscribe(new ErrorHandleSubscriber<Token>(mErrorHandler) {
          @Override
          public void onError(@NonNull Throwable e) {
            super.onError(e);
            if (e instanceof NoNetworkException) {
              view.showMessage("No Network Connection");
            }
            view.hideLoading();
          }

          @Override
          public void onNext(@NonNull Token token) {
            view.showToken(token);
          }
        });
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    view = null;
    mErrorHandler = null;
  }
}
