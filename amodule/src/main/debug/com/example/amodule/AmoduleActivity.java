package com.example.amodule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.base.BaseActivity;

/**
 * Created by Bill on 2017/8/2.
 */

public class AmoduleActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.amodule_activity);
    unbinder = ButterKnife.bind(this);
  }

  @OnClick(R.id.bt_project) void NavigateProjectActivity() {
    ARouter.getInstance().build("/amodule/activity").navigation();
  }
}
