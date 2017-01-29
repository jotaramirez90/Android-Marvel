package com.jota.marvel.app.di.module;

import com.jota.marvel.app.di.annotation.PerView;
import com.jota.marvel.domain.executor.PostExecutionThread;
import com.jota.marvel.domain.executor.ThreadExecutor;
import com.jota.marvel.domain.interactors.GetComics;
import com.jota.marvel.domain.repository.Repository;
import dagger.Module;
import dagger.Provides;

@Module public class MainModule {

  @Provides @PerView GetComics provideGetComics(Repository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GetComics(repository, threadExecutor, postExecutionThread);
  }
}
