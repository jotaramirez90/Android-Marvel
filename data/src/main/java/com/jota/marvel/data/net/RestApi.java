package com.jota.marvel.data.net;

import com.jota.marvel.data.entity.ComicsResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

  @GET("/v1/public/characters/{characterId}/comics") Observable<ComicsResponse> getComics(
      @Path("characterId") int characterId);
}
