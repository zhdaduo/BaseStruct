package com.example.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bill on 2017/8/2.
 */

public class LiveNetworkMonitor implements NetworkMonitor {

  private final Context applicationContext;

  public LiveNetworkMonitor(Context context) {
    applicationContext = context.getApplicationContext();
  }

  public boolean isConnected() {
    ConnectivityManager cm = (ConnectivityManager) applicationContext
        .getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }


}
