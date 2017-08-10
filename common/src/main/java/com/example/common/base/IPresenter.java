package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Bill on 2017/8/1.
 */

public interface IPresenter {

  void onStart(@Nullable Bundle savedInstanceState);
  void onResume();
  void onPause();
  void onSaveInstanceState(Bundle outState);
  void onDestroy();
}
