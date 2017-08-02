package com.example.common.util;

import com.example.common.base.IView;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import rx.Observable;
import rx.Observable.Transformer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by Bill on 2017/8/1.
 */

public class RxUtil {

  private RxUtil() {
  }

  public static <T> Transformer<T, T> applySchedulers(final IView view) {
    return new Transformer<T, T>() {

      @Override
      public Observable<T> call(Observable<T> observable) {
        return observable
            .subscribeOn(Schedulers.io())
            .retryWhen(new RetryWithDelay(3, 2))
            .doOnSubscribe(new Action0() {
              @Override
              public void call() {
                view.showLoading();
              }
            })
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(new Action0() {
              @Override
              public void call() {
                view.hideLoading();
              }
            });
      }
    };
  }

  public static <T> LifecycleTransformer<T> bindToLifecycle(IView view) {
    if (view instanceof RxAppCompatActivity) {
      return ((RxAppCompatActivity) view).bindToLifecycle();
    } else if (view instanceof RxFragment) {
      return ((RxFragment) view).bindToLifecycle();
    } else {
      throw new IllegalArgumentException("view isn't activity or fragment");
    }

  }
}
