package com.jota.marvel.app.di.component.main;

import com.jota.marvel.app.di.annotation.PerView;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.module.MainModule;
import com.jota.marvel.ui.features.main.view.MainActivity;
import dagger.Component;

@PerView @Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent extends ViewComponent<MainActivity> {

  @Override void inject(MainActivity view);
}
