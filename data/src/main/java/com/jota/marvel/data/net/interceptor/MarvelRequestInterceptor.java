package com.jota.marvel.data.net.interceptor;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MarvelRequestInterceptor implements Interceptor {

  public static final String PARAM_KEY = "apikey";
  public static final String PARAM_TIMESTAMP = "ts";
  public static final String PARAM_HASH = "hash";
  private String mPublicKey;
  private String mPrivateKey;

  public MarvelRequestInterceptor(String publicKey, String privateKey) {
    this.mPublicKey = publicKey;
    this.mPrivateKey = privateKey;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    long timeStamp = System.currentTimeMillis();
    String hash = generateMarvelHash(timeStamp, mPrivateKey, mPublicKey);

    Request original = chain.request();
    HttpUrl originalHttpUrl = original.url();
    HttpUrl url = originalHttpUrl.newBuilder()
        .addQueryParameter(PARAM_TIMESTAMP, String.valueOf(timeStamp))
        .addQueryParameter(PARAM_KEY, mPublicKey)
        .addQueryParameter(PARAM_HASH, hash)
        .build();

    Request.Builder requestBuilder = original.newBuilder().url(url);
    Request request = requestBuilder.build();
    return chain.proceed(request);
  }

  private String generateMarvelHash(long timeStamp, String privateKey, String publicKey) {
    String marvelHash = timeStamp + privateKey + publicKey;
    return md5(marvelHash);
  }

  public static final String md5(final String s) {
    final String MD5 = "MD5";
    try {
      MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
      digest.update(s.getBytes());
      byte messageDigest[] = digest.digest();

      StringBuilder hexString = new StringBuilder();
      for (byte aMessageDigest : messageDigest) {
        String h = Integer.toHexString(0xFF & aMessageDigest);
        while (h.length() < 2) {
          h = "0" + h;
        }
        hexString.append(h);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
