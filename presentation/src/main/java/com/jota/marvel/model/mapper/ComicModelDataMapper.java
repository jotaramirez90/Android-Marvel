package com.jota.marvel.model.mapper;

import com.jota.marvel.domain.model.Comic;
import com.jota.marvel.model.ComicModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.inject.Inject;

public class ComicModelDataMapper {

  @Inject public ComicModelDataMapper() {
  }

  public ComicModel transform(Comic comic) {
    if (comic == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    ComicModel comicModel = new ComicModel();
    comicModel.setId(comic.getId());
    comicModel.setTitle(comic.getTitle());
    comicModel.setDescription(comic.getDescription());
    comicModel.setThumbnailUrl(comic.getThumbnailUrl());
    comicModel.setImagesUrl(comic.getImagesUrl());

    return comicModel;
  }

  public Collection<ComicModel> transform(Collection<Comic> comicCollection) {
    Collection<ComicModel> comicModelCollection;
    if (comicCollection != null && !comicCollection.isEmpty()) {
      comicModelCollection = new ArrayList<>();
      for (Comic user : comicCollection) {
        comicModelCollection.add(transform(user));
      }
    } else {
      comicModelCollection = Collections.emptyList();
    }

    return comicModelCollection;
  }
}
