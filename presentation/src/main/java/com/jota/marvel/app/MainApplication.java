package com.jota.marvel.app;

import android.app.Application;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.component.application.DaggerApplicationComponent;
import com.jota.marvel.app.di.module.ApplicationModule;

public class MainApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    buildApplicationComponent();
    inject();
  }

  private void buildApplicationComponent() {
    mApplicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  private void inject() {
    mApplicationComponent.inject(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return mApplicationComponent;
  }
}
