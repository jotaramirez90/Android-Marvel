package com.jota.marvel.data.repository.datasource;

import com.jota.marvel.data.ApplicationTestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DataStoreFactoryTest extends ApplicationTestCase {

  private DataStoreFactory mDataStoreFactory;

  @Mock private CloudData mockCloudData;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mDataStoreFactory = new DataStoreFactory(mockCloudData);
  }

  @Test public void testFromCloudData() {
    CloudData cloudData = mDataStoreFactory.fromCloudData();

    assertThat(cloudData, is(notNullValue()));
    assertThat(cloudData, is(instanceOf(CloudData.class)));
  }
}
