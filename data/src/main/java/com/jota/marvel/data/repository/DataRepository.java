package com.jota.marvel.data.repository;

import com.jota.marvel.data.repository.datasource.DataStoreFactory;
import com.jota.marvel.domain.repository.Repository;
import javax.inject.Inject;

public class DataRepository implements Repository {

  private final DataStoreFactory mDataStoreFactory;
  private int mCharacterId;

  @Inject public DataRepository(DataStoreFactory dataStoreFactory) {
    this.mDataStoreFactory = dataStoreFactory;
  }

  public void initialize(int characterId) {
    this.mCharacterId = characterId;
  }
}
