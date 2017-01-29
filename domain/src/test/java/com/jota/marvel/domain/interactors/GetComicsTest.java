package com.jota.marvel.domain.interactors;

import com.jota.marvel.domain.executor.PostExecutionThread;
import com.jota.marvel.domain.executor.ThreadExecutor;
import com.jota.marvel.domain.repository.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class) public class GetComicsTest {

  private GetComics mGetComics;

  @Mock private Repository mockRepository;
  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Before public void setUp() {
    mGetComics = new GetComics(mockRepository, mockThreadExecutor, mockPostExecutionThread);
  }

  @Test public void testGetComicsUseCaseObservableHappyCase() {
    mGetComics.buildUseCaseObservable(null);

    verify(mockRepository).getComics();
    verifyNoMoreInteractions(mockRepository);
    verifyZeroInteractions(mockPostExecutionThread);
    verifyZeroInteractions(mockThreadExecutor);
  }
}
