package com.jota.marvel.data.entity;

public class ComicsResponse {

  private int code;
  private String status;
  private DataEntity data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DataEntity getDataEntity() {
    return data;
  }

  public void setDataEntity(DataEntity dataEntity) {
    this.data = dataEntity;
  }
}
