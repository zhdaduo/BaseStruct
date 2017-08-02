package com.example.common.base;

import butterknife.Unbinder;
import com.example.common.di.AppComponent;
import com.example.common.di.GlobalAppComponent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import javax.inject.Inject;

/**
 * Created by Bill on 2017/8/1.
 */

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity {

  protected Unbinder unbinder;

  @Inject
  protected P mPresenter;

  protected AppComponent getAppComponent() {
    return GlobalAppComponent.getAppComponent();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (mPresenter != null) mPresenter.onDestroy();//释放资源
    this.mPresenter = null;

    if(unbinder != null){
      unbinder.unbind();
    }
  }
}
