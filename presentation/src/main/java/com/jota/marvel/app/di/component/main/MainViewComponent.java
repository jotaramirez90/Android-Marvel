package com.jota.marvel.app.di.component.main;

import com.jota.marvel.app.di.annotation.PerView;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.module.MainViewModule;
import com.jota.marvel.ui.features.main.view.MainActivity;
import dagger.Component;

@PerView @Component(dependencies = ApplicationComponent.class, modules = MainViewModule.class)
public interface MainViewComponent extends ViewComponent<MainActivity> {

  @Override void inject(MainActivity view);
}
