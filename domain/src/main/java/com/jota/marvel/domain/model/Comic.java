package com.jota.marvel.domain.model;

import java.util.List;

public class Comic {

  private int id;
  private String title;
  private String description;
  private String thumbnailUrl;
  private List<String> imagesUrl;

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public List<String> getImagesUrl() {
    return imagesUrl;
  }

  public void setImagesUrl(List<String> imagesUrl) {
    this.imagesUrl = imagesUrl;
  }
}
