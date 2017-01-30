package com.jota.marvel.app.di.component.comiclist;

import com.jota.marvel.app.di.annotation.PerView;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.module.ComicListModule;
import com.jota.marvel.ui.features.comiclist.view.ComicListFragment;
import dagger.Component;

@PerView @Component(dependencies = ApplicationComponent.class, modules = ComicListModule.class)
public interface ComicListComponent extends ViewComponent<ComicListFragment> {

  @Override void inject(ComicListFragment view);
}
