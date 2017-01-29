package com.jota.marvel.app.di.component.application;

import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.di.module.ApplicationModule;
import com.jota.marvel.app.di.module.DataSourceModule;
import com.jota.marvel.app.di.module.RepositoryModule;
import com.jota.marvel.domain.executor.PostExecutionThread;
import com.jota.marvel.domain.executor.ThreadExecutor;
import com.jota.marvel.domain.repository.Repository;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { ApplicationModule.class, RepositoryModule.class, DataSourceModule.class })
public interface ApplicationComponent {

  void inject(MainApplication mainApplication);

  ThreadExecutor threadExecutor();

  PostExecutionThread postExecutionThread();

  Repository repository();
}
