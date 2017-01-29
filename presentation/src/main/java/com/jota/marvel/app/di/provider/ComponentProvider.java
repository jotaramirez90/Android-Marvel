package com.jota.marvel.app.di.provider;

import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.component.main.DaggerMainComponent;
import com.jota.marvel.app.di.component.main.MainComponent;
import com.jota.marvel.app.di.module.MainModule;

public final class ComponentProvider {

  private static MainComponent mMainComponent = null;

  private ComponentProvider() {
  }

  public static MainComponent getMainComponent(ApplicationComponent applicationComponent) {
    if (mMainComponent == null) {
      mMainComponent = DaggerMainComponent.builder()
          .applicationComponent(applicationComponent)
          .mainModule(new MainModule())
          .build();
    }
    return mMainComponent;
  }
}
