package com.jota.marvel.data.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultEntity {

  private String id;
  private String title;
  private String description;
  private ThumbnailEntity thumbnail;
  private List<ImageEntity> imageEntities = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ThumbnailEntity getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(ThumbnailEntity thumbnail) {
    this.thumbnail = thumbnail;
  }

  public List<ImageEntity> getImageEntities() {
    return imageEntities;
  }

  public void setImageEntities(List<ImageEntity> imageEntities) {
    this.imageEntities = imageEntities;
  }
}
