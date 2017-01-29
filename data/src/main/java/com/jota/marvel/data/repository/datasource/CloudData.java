package com.jota.marvel.data.repository.datasource;

import com.jota.marvel.data.entity.ComicsResponse;
import io.reactivex.Observable;

public interface CloudData {

  Observable<ComicsResponse> getComics(int characterId);
}
