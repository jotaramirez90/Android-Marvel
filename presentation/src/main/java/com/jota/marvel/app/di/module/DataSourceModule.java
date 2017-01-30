package com.jota.marvel.app.di.module;

import com.jota.marvel.data.repository.datasource.CloudData;
import com.jota.marvel.data.repository.datasource.CloudDataStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class DataSourceModule {

  @Provides @Named("endpoint") public String provideEndpoint() {
    return "http://gateway.marvel.com";
  }

  @Provides @Named("public_api_key") public String providePublicKey() {
    return "fakePublicKey";
  }

  @Provides @Named("private_api_key") public String providePrivateKey() {
    return "fakePrivateKey";
  }

  @Provides @Singleton public CloudData provideDataRepository(@Named("endpoint") String endpoint,
      @Named("public_api_key") String publicKey, @Named("private_api_key") String privateKey) {
    return new CloudDataStore(endpoint, publicKey, privateKey);
  }
}
