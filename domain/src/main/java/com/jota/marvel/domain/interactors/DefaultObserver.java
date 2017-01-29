package com.jota.marvel.domain.interactors;

import io.reactivex.observers.DisposableObserver;

public class DefaultObserver<T> extends DisposableObserver<T> {
  @Override public void onNext(T value) {

  }

  @Override public void onError(Throwable e) {

  }

  @Override public void onComplete() {

  }
}
