package com.jota.marvel.ui.features.main.presenter;

import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.main.view.MainActivity;

public class MainPresenter extends BasePresenter<MainActivity> {

  private boolean initial = true;

  public MainPresenter() {
  }

  @Override public void viewPrepared() {
    super.viewPrepared();
    if (initial) {
      initial = false;
      view.showComics();
    }
  }
}
