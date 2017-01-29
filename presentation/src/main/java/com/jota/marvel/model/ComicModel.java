package com.jota.marvel.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ComicModel implements Parcelable {

  private int id;
  private String title;
  private String description;
  private String thumbnailUrl;
  private List<String> imagesUrl;

  public ComicModel() {
  }

  public ComicModel(int id, String title, String description, String thumbnailUrl,
      List<String> imagesUrl) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.thumbnailUrl = thumbnailUrl;
    this.imagesUrl = imagesUrl;
  }

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

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(id);
    parcel.writeString(title);
    parcel.writeString(description);
    parcel.writeString(thumbnailUrl);
    parcel.writeList(imagesUrl);
  }

  protected ComicModel(Parcel in) {
    id = in.readInt();
    title = in.readString();
    description = in.readString();
    thumbnailUrl = in.readString();
    imagesUrl = new ArrayList<>();
    in.readList(imagesUrl, null);
  }

  public static final Creator<ComicModel> CREATOR = new Creator<ComicModel>() {
    @Override public ComicModel createFromParcel(Parcel parcel) {
      return new ComicModel(parcel);
    }

    @Override public ComicModel[] newArray(int size) {
      return new ComicModel[size];
    }
  };
}
