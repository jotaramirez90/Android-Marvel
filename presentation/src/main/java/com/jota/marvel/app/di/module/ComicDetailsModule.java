package com.jota.marvel.app.di.module;

import com.jota.marvel.ui.features.comicdetails.presenter.ComicDetailsPresenter;
import dagger.Module;
import dagger.Provides;

@Module public class ComicDetailsModule {

  @Provides public ComicDetailsPresenter provideComicDetailsPresenter() {
    return new ComicDetailsPresenter();
  }
}
