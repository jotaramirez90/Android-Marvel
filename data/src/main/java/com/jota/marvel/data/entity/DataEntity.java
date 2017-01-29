package com.jota.marvel.data.entity;

import java.util.ArrayList;
import java.util.List;

public class DataEntity {

  private List<ResultEntity> results = new ArrayList<>();

  public List<ResultEntity> getResults() {
    return results;
  }

  public void setResults(List<ResultEntity> resultEntities) {
    this.results = resultEntities;
  }
}
