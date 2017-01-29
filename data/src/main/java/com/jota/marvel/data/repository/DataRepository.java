package com.jota.marvel.data.repository;

import com.jota.marvel.data.entity.mapper.ResultDataMapper;
import com.jota.marvel.data.repository.datasource.CloudData;
import com.jota.marvel.data.repository.datasource.DataStoreFactory;
import com.jota.marvel.domain.model.Comic;
import com.jota.marvel.domain.repository.Repository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

public class DataRepository implements Repository {

  private final DataStoreFactory mDataStoreFactory;
  private final ResultDataMapper mResultDataMapper;
  private int mCharacterId;

  @Inject public DataRepository(DataStoreFactory dataStoreFactory) {
    this.mDataStoreFactory = dataStoreFactory;
    this.mResultDataMapper = new ResultDataMapper();
  }

  public void initialize(int characterId) {
    this.mCharacterId = characterId;
  }

  @Override public Observable<List<Comic>> getComics() {
    final CloudData cloudData = mDataStoreFactory.fromCloudData();
    return cloudData.getComics(mCharacterId).map(mResultDataMapper::transform);
  }
}
