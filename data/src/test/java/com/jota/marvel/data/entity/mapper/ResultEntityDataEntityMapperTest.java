package com.jota.marvel.data.entity.mapper;

import com.jota.marvel.data.ApplicationTestCase;
import com.jota.marvel.data.entity.ResultEntity;
import com.jota.marvel.data.entity.ThumbnailEntity;
import com.jota.marvel.domain.model.Comic;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultEntityDataEntityMapperTest extends ApplicationTestCase {

  private static final String FAKE_ID = "1";
  private static final String FAKE_TITLE = "title";
  private static final String FAKE_DESCRIPTION = "description";
  private static final String FAKE_PATH = "path";
  private static final String FAKE_EXTENSION = "extension";

  private ResultDataMapper mResultDataMapper;

  @Before public void setUp() throws Exception {
    mResultDataMapper = new ResultDataMapper();
  }

  @Test public void testTransformUserProfile() {
    ResultEntity resultEntity = createFakeResultEntity();
    Comic comic = mResultDataMapper.transform(resultEntity);

    assertThat(comic.getId(), is(equalTo(1)));
    assertThat(comic.getTitle(), is(FAKE_TITLE));
    assertThat(comic.getDescription(), is(FAKE_DESCRIPTION));
    assertThat(comic.getThumbnailUrl(), is(FAKE_PATH + "." + FAKE_EXTENSION));
  }

  private ResultEntity createFakeResultEntity() {
    ResultEntity resultEntity = new ResultEntity();
    resultEntity.setId(FAKE_ID);
    resultEntity.setTitle(FAKE_TITLE);
    resultEntity.setDescription(FAKE_DESCRIPTION);
    ThumbnailEntity thumbnailEntity = mock(ThumbnailEntity.class);
    when(thumbnailEntity.getPath()).thenReturn(FAKE_PATH);
    when(thumbnailEntity.getExtension()).thenReturn(FAKE_EXTENSION);
    resultEntity.setThumbnail(thumbnailEntity);

    return resultEntity;
  }
}
