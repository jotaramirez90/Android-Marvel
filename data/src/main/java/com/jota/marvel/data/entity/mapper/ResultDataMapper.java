package com.jota.marvel.data.entity.mapper;

import com.jota.marvel.data.entity.ComicsResponse;
import com.jota.marvel.data.entity.ImageEntity;
import com.jota.marvel.data.entity.ResultEntity;
import com.jota.marvel.domain.model.Comic;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class ResultDataMapper {

  @Inject public void ResultDataMapper() {
  }

  public Comic transform(ResultEntity resultEntity) {
    Comic comic = null;
    if (resultEntity != null) {
      comic = new Comic();
      comic.setId(mapId(resultEntity));
      comic.setTitle(resultEntity.getTitle());
      comic.setDescription(resultEntity.getDescription());
      comic.setThumbnailUrl(mapThumbnail(resultEntity));
      comic.setImagesUrl(mapImages(resultEntity));
    }
    return comic;
  }

  public List<Comic> transform(ComicsResponse comicsResponse) {
    List<Comic> comics = new ArrayList<>();
    for (ResultEntity resultEntity : comicsResponse.getDataEntity().getResults()) {
      Comic tranformComic = transform(resultEntity);
      if (tranformComic != null) {
        comics.add(tranformComic);
      }
    }
    return comics;
  }

  private int mapId(ResultEntity resultEntity) {
    return Integer.valueOf(resultEntity.getId());
  }

  private String mapThumbnail(ResultEntity resultEntity) {
    return parseImage(resultEntity.getThumbnail());
  }

  private List<String> mapImages(ResultEntity resultEntity) {
    List<String> images = new ArrayList<>();
    for (ImageEntity imageEntity : resultEntity.getImageEntities()) {
      images.add(parseImage(imageEntity));
    }
    return images;
  }

  private String parseImage(ImageEntity imageEntity) {
    return imageEntity.getPath() + "." + imageEntity.getExtension();
  }
}
