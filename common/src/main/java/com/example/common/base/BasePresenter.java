package com.example.common.base;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Bill on 2017/8/1.
 */

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {

  protected M mModel;
  protected V mView;

  public BasePresenter(M mModel, V mView) {
    this.mModel = mModel;
    this.mView = mView;
    onStart();
  }

  public BasePresenter(V rootView) {
    this.mView = rootView;
    onStart();
  }

  public BasePresenter() {
    onStart();
  }

  @Override
  public void onStart() {
    if (useEventBus()) {
      EventBus.getDefault().register(this);
    }
  }

  @Override
  public void onDestroy() {
    if (useEventBus()) {
      EventBus.getDefault().unregister(this);
    }
    if (mModel != null) {
      mModel.onDestroy();
    }
    this.mModel = null;
    this.mView = null;
  }

  protected boolean useEventBus() {
    return false;
  }
}
