package com.jota.marvel.app.di.component.comicdetails;

import com.jota.marvel.app.di.annotation.PerView;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.module.ComicDetailsModule;
import com.jota.marvel.ui.features.comicdetails.view.ComicDetailFragment;
import dagger.Component;

@PerView @Component(dependencies = ApplicationComponent.class, modules = ComicDetailsModule.class)
public interface ComicDetailsComponent extends ViewComponent<ComicDetailFragment> {

  @Override void inject(ComicDetailFragment view);
}
