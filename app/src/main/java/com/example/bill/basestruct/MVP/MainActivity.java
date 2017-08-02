package com.example.bill.basestruct.MVP;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.bill.basestruct.R;
import com.example.bill.basestruct.model.bean.Token;
import com.example.common.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

  private TextView tv_token;
  private ProgressBar progressBar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    unbinder = ButterKnife.bind(this);

    DaggerMainComponent
        .builder()
        .appComponent(getAppComponent())
        .mainModule(new MainModule(this))
        .build()
        .inject(this);

    tv_token = (TextView) findViewById(R.id.token);
    progressBar = (ProgressBar) findViewById(R.id.progress);
    //https://www.diycode.cc/
    mPresenter.getToken("diycode name", "diycode pass");
  }

  @Override
  public void showLoading() {
    tv_token.setVisibility(View.GONE);
  }

  @Override
  public void hideLoading() {
    progressBar.setVisibility(View.GONE);
    tv_token.setVisibility(View.VISIBLE);
  }

  @Override
  public void showMessage(String message) {
    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showToken(Token token) {
    tv_token.setText(token.toString());
  }

  @OnClick(R.id.bt_amodule) void gotoAmodule() {
    ARouter.getInstance().build("/amodule/activity").navigation();
  }
}
