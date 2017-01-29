package com.jota.marvel.domain.repository;

import com.jota.marvel.domain.model.Comic;
import io.reactivex.Observable;
import java.util.List;

public interface Repository {

  Observable<List<Comic>> getComics();
}
