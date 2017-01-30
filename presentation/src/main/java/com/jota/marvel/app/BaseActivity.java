package com.jota.marvel.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.View;

public abstract class BaseActivity extends AppCompatActivity implements View {

  protected android.view.View mView;
  private BasePresenter mPresenter;

  public abstract ViewComponent bindViewComponent();

  public abstract BasePresenter bindPresenter();

  public abstract int bindLayout();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initialize();
  }

  @Override protected void onResume() {
    super.onResume();
    mPresenter.resume();
  }

  @Override protected void onPause() {
    super.onPause();
    mPresenter.pause();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mPresenter.destroy();
  }

  protected void initialize() {
    bindViewComponent().inject(this);
    this.mPresenter = bindPresenter();
    this.mPresenter.attachView(this);
    mView = getLayoutInflater().inflate(bindLayout(), null);
    setContentView(mView);
    ButterKnife.bind(this);
    onViewPrepared();
  }

  public void onViewPrepared() {
  }
}
