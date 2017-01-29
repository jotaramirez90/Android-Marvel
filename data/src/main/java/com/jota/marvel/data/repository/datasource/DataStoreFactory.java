package com.jota.marvel.data.repository.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class DataStoreFactory {

  private final CloudData mCloudData;

  @Inject public DataStoreFactory(CloudData cloudData) {
    this.mCloudData = cloudData;
  }

  public CloudData fromCloudData() {
    return mCloudData;
  }
}
