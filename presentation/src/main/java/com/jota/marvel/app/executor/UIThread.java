package com.jota.marvel.app.executor;

import com.jota.marvel.domain.executor.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;

public class UIThread implements PostExecutionThread {

  @Inject public UIThread() {
  }

  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
