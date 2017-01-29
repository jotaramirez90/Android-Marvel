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
    return "6a7ed890b4b941a925202a5630d5b162";
  }

  @Provides @Named("private_api_key") public String providePrivateKey() {
    return "0f1d0fdf46a0bf32f962b0b9997233c0395cdf8e";
  }

  @Provides @Singleton public CloudData provideDataRepository(@Named("endpoint") String endpoint,
      @Named("public_api_key") String publicKey, @Named("private_api_key") String privateKey) {
    return new CloudDataStore(endpoint, publicKey, privateKey);
  }
}
