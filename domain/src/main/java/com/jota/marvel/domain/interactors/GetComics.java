package com.jota.marvel.domain.interactors;

import com.jota.marvel.domain.executor.PostExecutionThread;
import com.jota.marvel.domain.executor.ThreadExecutor;
import com.jota.marvel.domain.model.Comic;
import com.jota.marvel.domain.repository.Repository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

public class GetComics extends UseCase<List<Comic>, Void> {

  private final Repository mRepository;

  @Inject public GetComics(Repository repository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = repository;
  }

  @Override Observable<List<Comic>> buildUseCaseObservable(Void aVoid) {
    return mRepository.getComics();
  }
}
