package com.jota.marvel.ui.features.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindString;
import butterknife.BindView;
import com.jota.marvel.R;
import com.jota.marvel.app.BaseActivity;
import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.provider.ComponentProvider;
import com.jota.marvel.app.navigator.Navigator;
import com.jota.marvel.model.ComicModel;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.comicdetails.view.ComicDetailFragment;
import com.jota.marvel.ui.features.comiclist.view.ComicListFragment;
import com.jota.marvel.ui.features.comiclist.view.ComicListListener;
import com.jota.marvel.ui.features.main.presenter.MainPresenter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ComicListListener {

  @Inject protected MainPresenter mMainPresenter;
  @Inject protected Navigator mNavigator;

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindString(R.string.tag_landscape) String tagPortrait;
  @BindString(R.string.tag_landscape) String tagLandscape;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return ComponentProvider.getMainComponent(applicationComponent);
  }

  @Override public BasePresenter bindPresenter() {
    return mMainPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.activity_main;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setSupportActionBar(mToolbar);
    mToolbar.setTitle(getTitle());
  }

  @Override public void onViewPrepared() {
    super.onViewPrepared();
    mMainPresenter.viewPrepared();
  }

  public void showComics() {
    ComicListFragment comicListFragment = ComicListFragment.newInstance();
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.comicsFrame, comicListFragment)
        .commit();
  }

  @Override public void onItemClick(ComicModel comicModel) {
    if (tagPortrait.equals(mView.getTag())) {
      ComicDetailFragment comicDetailFragment = ComicDetailFragment.newInstance(comicModel);
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.detailsFrame, comicDetailFragment)
          .commit();
    } else {
      mNavigator.navigateToDetails(this, comicModel);
    }
  }
}
