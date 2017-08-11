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

  private RxErrorHandler mErrorHandler;

  @Inject
  public MainPresenter(MainContract.Model model, MainContract.View view, RxErrorHandler handler) {
    super(model, view);
    this.mErrorHandler = handler;
  }

  public void getToken(String username, String password) {
    mModel.getToken(username, password)
        .compose(RxUtil.applySchedulers(mView))
        .compose(RxUtil.bindToLifecycle(mView))
        .subscribe(new ErrorHandleSubscriber<Token>(mErrorHandler) {
          @Override
          public void onError(@NonNull Throwable e) {
            super.onError(e);
            if (e instanceof NoNetworkException) {
              mView.showMessage("No Network Connection");
            }
            mView.hideLoading();
          }

          @Override
          public void onNext(@NonNull Token token) {
            mView.showToken(token);
          }
        });
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mErrorHandler = null;
  }
}
