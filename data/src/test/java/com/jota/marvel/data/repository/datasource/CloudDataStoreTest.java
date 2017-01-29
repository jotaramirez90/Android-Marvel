package com.jota.marvel.data.repository.datasource;

import com.jota.marvel.data.ApplicationTestCase;
import com.jota.marvel.data.entity.ComicsResponse;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CloudDataStoreTest extends ApplicationTestCase {

  private static final String FAKE_ENDPOINT = "http://gateway.marvel.com";
  private static final String FAKE_PUBLIC_KEY = "publicKey";
  private static final String FAKE_PRIVATE_KEY = "privateKey";
  private static final int FAKE_CHARACTER_ID = 1;

  private CloudDataStore mCloudDataStore;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mCloudDataStore = new CloudDataStore(FAKE_ENDPOINT, FAKE_PUBLIC_KEY, FAKE_PRIVATE_KEY);
  }

  @Test public void testGetComics() {
    ComicsResponse fakeComicsResponse = mock(ComicsResponse.class);
    given(mCloudDataStore.getComics(FAKE_CHARACTER_ID)).willReturn(
        Observable.just(fakeComicsResponse));

    mCloudDataStore.getComics(FAKE_CHARACTER_ID);
    verify(mCloudDataStore).getComics(FAKE_CHARACTER_ID);
  }
}
