package com.jota.marvel.app.di.module;

import android.content.Context;
import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.executor.UIThread;
import com.jota.marvel.app.navigator.Navigator;
import com.jota.marvel.data.executor.JobExecutor;
import com.jota.marvel.domain.executor.PostExecutionThread;
import com.jota.marvel.domain.executor.ThreadExecutor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private final MainApplication application;

  public ApplicationModule(MainApplication mainApplication) {
    this.application = mainApplication;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton Navigator provideNavigator() {
    return new Navigator();
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }
}
