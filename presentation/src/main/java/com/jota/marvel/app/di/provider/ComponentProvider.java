package com.jota.marvel.app.di.provider;

import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.component.comicdetails.ComicDetailsComponent;
import com.jota.marvel.app.di.component.comicdetails.DaggerComicDetailsComponent;
import com.jota.marvel.app.di.component.comiclist.ComicListComponent;
import com.jota.marvel.app.di.component.comiclist.DaggerComicListComponent;
import com.jota.marvel.app.di.component.details.DaggerDetailsViewComponent;
import com.jota.marvel.app.di.component.details.DetailsViewComponent;
import com.jota.marvel.app.di.component.main.DaggerMainViewComponent;
import com.jota.marvel.app.di.component.main.MainViewComponent;
import com.jota.marvel.app.di.module.ComicDetailsModule;
import com.jota.marvel.app.di.module.ComicListModule;
import com.jota.marvel.app.di.module.DetailsViewModule;
import com.jota.marvel.app.di.module.MainViewModule;

public final class ComponentProvider {

  private static MainViewComponent mMainViewComponent = null;
  private static DetailsViewComponent mDetailsViewComponent = null;
  private static ComicListComponent mComicListComponent = null;
  private static ComicDetailsComponent mComicDetailsComponent = null;

  private ComponentProvider() {
  }

  public static MainViewComponent getMainComponent(ApplicationComponent applicationComponent) {
    if (mMainViewComponent == null) {
      mMainViewComponent = DaggerMainViewComponent.builder()
          .applicationComponent(applicationComponent)
          .mainViewModule(new MainViewModule())
          .build();
    }
    return mMainViewComponent;
  }

  public static DetailsViewComponent getDetailsViewComponent(
      ApplicationComponent applicationComponent) {
    if (mDetailsViewComponent == null) {
      mDetailsViewComponent = DaggerDetailsViewComponent.builder()
          .applicationComponent(applicationComponent)
          .detailsViewModule(new DetailsViewModule())
          .build();
    }
    return mDetailsViewComponent;
  }

  public static ComicListComponent getComicListComponent(
      ApplicationComponent applicationComponent) {
    if (mComicListComponent == null) {
      mComicListComponent = DaggerComicListComponent.builder()
          .applicationComponent(applicationComponent)
          .comicListModule(new ComicListModule())
          .build();
    }
    return mComicListComponent;
  }

  public static ComicDetailsComponent getComicDetailsComponent(
      ApplicationComponent applicationComponent) {
    if (mComicDetailsComponent == null) {
      mComicDetailsComponent = DaggerComicDetailsComponent.builder()
          .applicationComponent(applicationComponent)
          .comicDetailsModule(new ComicDetailsModule())
          .build();
    }
    return mComicDetailsComponent;
  }
}
