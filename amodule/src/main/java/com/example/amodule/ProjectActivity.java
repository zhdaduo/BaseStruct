package com.example.amodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/amodule/activity")
public class ProjectActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project);
  }
}
