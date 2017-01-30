package com.jota.marvel.app.di.component.details;

import com.jota.marvel.app.di.annotation.PerView;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.module.DetailsViewModule;
import com.jota.marvel.ui.features.detail.view.DetailsActivity;
import dagger.Component;

@PerView @Component(dependencies = ApplicationComponent.class, modules = DetailsViewModule.class)
public interface DetailsViewComponent extends ViewComponent<DetailsActivity> {

  @Override void inject(DetailsActivity view);
}
