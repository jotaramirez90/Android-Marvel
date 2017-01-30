package com.jota.marvel.app.di.module;

import com.jota.marvel.ui.features.detail.presenter.DetailsPresenter;
import dagger.Module;
import dagger.Provides;

@Module public class DetailsViewModule {

  @Provides public DetailsPresenter provideDetailsPresenter() {
    return new DetailsPresenter();
  }
}
