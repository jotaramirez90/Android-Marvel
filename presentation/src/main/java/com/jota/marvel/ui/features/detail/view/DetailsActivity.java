package com.jota.marvel.ui.features.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.jota.marvel.R;
import com.jota.marvel.app.BaseActivity;
import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.provider.ComponentProvider;
import com.jota.marvel.model.ComicModel;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.comicdetails.view.ComicDetailFragment;
import com.jota.marvel.ui.features.detail.presenter.DetailsPresenter;
import javax.inject.Inject;

public class DetailsActivity extends BaseActivity {

  private static final String PARAM_COMIC = "comicParam";

  @Inject protected DetailsPresenter mDetailsPresenter;

  public static Intent getCallingIntent(Context context, ComicModel comicModel) {
    Intent callingIntent = new Intent(context, DetailsActivity.class);
    callingIntent.putExtra(PARAM_COMIC, comicModel);
    return callingIntent;
  }

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return ComponentProvider.getDetailsViewComponent(applicationComponent);
  }

  @Override public BasePresenter bindPresenter() {
    return mDetailsPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.activity_details;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle bundle = getIntent().getExtras();
    ComicModel comicModel = bundle.getParcelable(PARAM_COMIC);

    ComicDetailFragment comicDetailFragment = ComicDetailFragment.newInstance(comicModel);
    getSupportFragmentManager().beginTransaction()
        .add(R.id.detailsContainer, comicDetailFragment)
        .commit();
  }
}
