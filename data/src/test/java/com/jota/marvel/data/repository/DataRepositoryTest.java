package com.jota.marvel.data.repository;

import com.jota.marvel.data.ApplicationTestCase;
import com.jota.marvel.data.entity.ComicsResponse;
import com.jota.marvel.data.repository.datasource.CloudData;
import com.jota.marvel.data.repository.datasource.DataStoreFactory;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class DataRepositoryTest extends ApplicationTestCase {

  private static final int FAKE_CHARACTER_ID = 1;

  private DataRepository mDataRepository;

  @Mock DataStoreFactory mockDataStoreFactory;
  @Mock CloudData mockCloudData;
  @Mock ComicsResponse mockComicsResponse;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mDataRepository = new DataRepository(mockDataStoreFactory);
    mDataRepository.initialize(FAKE_CHARACTER_ID);

    given(mockDataStoreFactory.fromCloudData()).willReturn(mockCloudData);
  }

  @Test public void testGetComics() {
    given(mockCloudData.getComics(FAKE_CHARACTER_ID)).willReturn(
        Observable.just(mockComicsResponse));
    mDataRepository.getComics();

    verify(mockDataStoreFactory).fromCloudData();
    verify(mockCloudData).getComics(FAKE_CHARACTER_ID);
  }
}
