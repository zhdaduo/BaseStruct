package com.example.common.base;

import butterknife.Unbinder;
import com.example.common.di.AppComponent;
import com.example.common.di.GlobalAppComponent;
import com.trello.rxlifecycle.components.support.RxFragment;
import javax.inject.Inject;

/**
 * Created by Bill on 2017/8/1.
 */

public abstract class BaseFragment<P extends IPresenter> extends RxFragment {

  protected Unbinder unbinder;

  @Inject
  protected P mPresenter;

  protected AppComponent getAppComponent() {
    return GlobalAppComponent.getAppComponent();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    if(unbinder != null){
      unbinder.unbind();
    }
  }
}
