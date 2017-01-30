package com.jota.marvel.ui.main.presenter;

import com.jota.marvel.ui.features.main.presenter.MainPresenter;
import com.jota.marvel.ui.features.main.view.MainActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) public class MainPresenterTest {

  private MainPresenter mMainPresenter;

  @Mock private MainActivity mockMainActivity;

  @Before public void setUp() {
    mMainPresenter = new MainPresenter();
    mMainPresenter.attachView(mockMainActivity);
  }

  @Test @SuppressWarnings("unchecked") public void testGetCity() {
    mMainPresenter.viewPrepared();
  }
}
