package com.jota.marvel.ui.features.main.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.jota.marvel.R;
import com.jota.marvel.app.BaseActivity;
import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.provider.ComponentProvider;
import com.jota.marvel.model.DummyContent;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.main.presenter.MainPresenter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject protected MainPresenter mMainPresenter;

  private boolean mTwoPane;

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getApplication()).getApplicationComponent();
    return ComponentProvider.getMainComponent(applicationComponent);
  }

  @Override public BasePresenter bindPresenter() {
    return mMainPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.activity_item_list;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_item_list);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitle(getTitle());

    View recyclerView = findViewById(R.id.item_list);
    assert recyclerView != null;
    setupRecyclerView((RecyclerView) recyclerView);

    if (findViewById(R.id.item_detail_container) != null) {
      mTwoPane = true;
    }
  }

  private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
    recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
  }
}
