package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by Bill on 2017/8/1.
 */

public abstract class BasePresenter<M extends IModel, V extends IView> implements IPresenter {

  protected final M mModel;
  protected final V mView;

  public BasePresenter(M mModel, V rootView) {
    this.mModel = mModel;
    this.mView = rootView;
  }

  @Override
  public void onStart(@Nullable Bundle savedInstanceState) {
    if (useEventBus()) {
      EventBus.getDefault().register(this);
    }
  }

  @Override
  public void onResume() {

  }

  @Override
  public void onPause() {

  }

  @Override
  public void onSaveInstanceState(Bundle outState) {

  }

  @Override
  public void onDestroy() {
    if (useEventBus()) {
      EventBus.getDefault().unregister(this);
    }
    if (mModel != null) {
      mModel.onDestroy();
    }
  }

  protected boolean useEventBus() {
    return false;
  }
}
