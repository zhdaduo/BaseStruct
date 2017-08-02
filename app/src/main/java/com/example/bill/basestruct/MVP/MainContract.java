package com.example.bill.basestruct.MVP;

import com.example.bill.basestruct.model.bean.Token;
import com.example.common.base.IModel;
import com.example.common.base.IView;
import rx.Observable;

/**
 * Created by Bill on 2017/8/1.
 */

public interface MainContract {

  interface View extends IView {

    void showToken(Token token);
  }

  interface Model extends IModel {

    Observable<Token> getToken(String username, String password);
  }
}
