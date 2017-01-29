package com.jota.marvel.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.View;

public abstract class BaseFragment extends Fragment implements View {

  private BasePresenter mPresenter;

  public abstract ViewComponent bindViewComponent();

  public abstract BasePresenter bindPresenter();

  public abstract int bindLayout();

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initialize();
  }

  @Nullable @Override
  public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(bindLayout(), container, false);
  }

  @Override public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mPresenter.attachView(this);
    ButterKnife.bind(this, getView());
  }

  @Override public void onResume() {
    super.onResume();
    mPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    mPresenter.pause();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mPresenter.destroy();
  }

  protected void initialize() {
    bindViewComponent().inject(this);
    mPresenter = bindPresenter();
  }
}
