package com.jota.marvel.app.di.component;

import com.jota.marvel.ui.View;

public interface ViewComponent<T extends View> {

  void inject(T view);
}
