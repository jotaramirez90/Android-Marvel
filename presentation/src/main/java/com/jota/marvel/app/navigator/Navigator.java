package com.jota.marvel.app.navigator;

import android.content.Context;
import android.content.Intent;
import com.jota.marvel.model.ComicModel;
import com.jota.marvel.ui.features.detail.view.DetailsActivity;
import javax.inject.Inject;

public class Navigator {

  @Inject public Navigator() {
  }

  public void navigateToDetails(Context context, ComicModel comicModel) {
    if (context != null) {
      Intent intentToLaunch = DetailsActivity.getCallingIntent(context, comicModel);
      context.startActivity(intentToLaunch);
    }
  }
}
