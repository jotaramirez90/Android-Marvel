package com.jota.marvel.ui.features.comiclist.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.jota.marvel.R;
import com.jota.marvel.app.BaseFragment;
import com.jota.marvel.app.MainApplication;
import com.jota.marvel.app.di.component.ViewComponent;
import com.jota.marvel.app.di.component.application.ApplicationComponent;
import com.jota.marvel.app.di.provider.ComponentProvider;
import com.jota.marvel.model.ComicModel;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.comiclist.adapter.ComicItemListener;
import com.jota.marvel.ui.features.comiclist.adapter.ComicListAdapter;
import com.jota.marvel.ui.features.comiclist.presenter.ComicListPresenter;
import java.util.List;
import javax.inject.Inject;

public class ComicListFragment extends BaseFragment implements ComicItemListener {

  @Inject ComicListPresenter mComicListPresenter;

  @BindView(R.id.loading) ProgressBar mLoadingBar;
  @BindView(R.id.comicRecycler) RecyclerView mComicsRecycler;

  private ComicListAdapter mComicListAdapter;
  private ComicListListener mComicListListener;

  public static ComicListFragment newInstance() {
    return new ComicListFragment();
  }

  @Override public ViewComponent bindViewComponent() {
    ApplicationComponent applicationComponent =
        ((MainApplication) getActivity().getApplication()).getApplicationComponent();
    return ComponentProvider.getComicListComponent(applicationComponent);
  }

  @Override public BasePresenter bindPresenter() {
    return mComicListPresenter;
  }

  @Override public int bindLayout() {
    return R.layout.fragment_comic_list;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof ComicListListener) {
      mComicListListener = (ComicListListener) context;
    }
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initComicList();
  }

  @Override public void onDetach() {
    super.onDetach();
    mComicListListener = null;
  }

  private void initComicList() {
    mComicListAdapter = new ComicListAdapter();
    mComicListAdapter.setComicItemListener(this);
    StaggeredGridLayoutManager mGridLayoutManager =
        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    mComicsRecycler.setLayoutManager(mGridLayoutManager);
    mComicsRecycler.setAdapter(mComicListAdapter);
  }

  public void showComics(List<ComicModel> comicModelList) {
    mLoadingBar.setVisibility(View.GONE);
    mComicListAdapter.addComics(comicModelList);
  }

  public void showError(String message) {
    Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void onItemClick(ComicModel comicModel) {
    if (mComicListListener != null) {
      mComicListListener.onItemClick(comicModel);
    }
  }
}
