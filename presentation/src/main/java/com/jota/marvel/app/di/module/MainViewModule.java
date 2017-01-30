package com.jota.marvel.app.di.module;

import com.jota.marvel.ui.features.main.presenter.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module public class MainViewModule {

  @Provides public MainPresenter provideMainPresenter() {
    return new MainPresenter();
  }
}
