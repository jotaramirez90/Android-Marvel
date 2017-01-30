package com.jota.marvel.ui.features.comiclist.presenter;

import com.jota.marvel.domain.interactors.DefaultObserver;
import com.jota.marvel.domain.interactors.GetComics;
import com.jota.marvel.domain.model.Comic;
import com.jota.marvel.model.mapper.ComicModelDataMapper;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.comiclist.view.ComicListFragment;
import java.util.List;

public class ComicListPresenter extends BasePresenter<ComicListFragment> {

  private GetComics mGetComics;
  private ComicModelDataMapper mComicModelDataMapper;

  public ComicListPresenter(GetComics getComics, ComicModelDataMapper comicModelDataMapper) {
    this.mGetComics = getComics;
    this.mComicModelDataMapper = comicModelDataMapper;
  }

  @Override public void resume() {
    super.resume();
    mGetComics.execute(new ComicsObserver(), null);
  }

  @Override public void destroy() {
    super.destroy();
    mGetComics.dispose();
  }

  private final class ComicsObserver extends DefaultObserver<List<Comic>> {
    @Override public void onNext(List<Comic> value) {
      super.onNext(value);
      view.showComics(mComicModelDataMapper.transform(value));
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
      view.showError(e.getMessage());
    }
  }
}
