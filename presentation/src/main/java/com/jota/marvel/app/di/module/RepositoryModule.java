package com.jota.marvel.app.di.module;

import com.jota.marvel.data.repository.DataRepository;
import com.jota.marvel.data.repository.datasource.DataStoreFactory;
import com.jota.marvel.domain.repository.Repository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class RepositoryModule {

  @Provides @Named("character_id") public int provideCharacterId() {
    return 1009220;
  }

  @Provides @Singleton public Repository provideRepository(DataStoreFactory dataStoreFactory,
      @Named("character_id") int characterId) {
    DataRepository dataRepository = new DataRepository(dataStoreFactory);
    dataRepository.initialize(characterId);
    return dataRepository;
  }
}
