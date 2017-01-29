package com.jota.marvel.ui.features.main.presenter;

import com.jota.marvel.domain.interactors.DefaultObserver;
import com.jota.marvel.domain.interactors.GetComics;
import com.jota.marvel.domain.model.Comic;
import com.jota.marvel.ui.BasePresenter;
import com.jota.marvel.ui.features.main.view.MainActivity;
import java.util.List;
import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainActivity> {

  private GetComics mGetComics;

  @Inject public MainPresenter(GetComics getComics) {
    this.mGetComics = getComics;
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
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
    }
  }
}
