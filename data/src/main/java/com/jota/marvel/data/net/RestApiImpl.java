package com.jota.marvel.data.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jota.marvel.data.net.interceptor.MarvelRequestInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiImpl {

  public static RestApi createRetrofitService(String endPoint, String publicKey,
      String privateKey) {
    final Retrofit restAdapter =
        new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(endPoint)
            .client(createHttpClient(publicKey, privateKey))
            .build();

    return restAdapter.create(RestApi.class);
  }

  private static OkHttpClient createHttpClient(String publicKey, String privateKey) {
    return new OkHttpClient.Builder().addInterceptor(
        new MarvelRequestInterceptor(publicKey, privateKey)).build();
  }
}
