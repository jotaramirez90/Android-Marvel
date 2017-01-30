package com.jota.marvel.ui;

public abstract class Presenter<T extends View> {

  protected T view;

  public void attachView(T view) {
    this.view = view;
  }

  public void viewPrepared() {
  }
}
