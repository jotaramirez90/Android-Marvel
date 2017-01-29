package com.jota.marvel.data.repository.datasource;

import com.jota.marvel.data.net.RestApi;
import com.jota.marvel.data.net.RestApiImpl;

public class CloudDataStore implements CloudData {

  private RestApi mRestApi;
  private String mEndPoint;
  private String mPublicKey;
  private String mPrivateKey;

  public CloudDataStore(String endPoint, String publicKey, String privateKey) {
    this.mEndPoint = endPoint;
    this.mPublicKey = publicKey;
    this.mPrivateKey = privateKey;
    buildRetrofit();
  }

  private void buildRetrofit() {
    mRestApi = RestApiImpl.createRetrofitService(mEndPoint, mPublicKey, mPrivateKey);
  }
}
