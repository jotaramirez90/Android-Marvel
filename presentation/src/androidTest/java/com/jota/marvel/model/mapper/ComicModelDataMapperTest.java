package com.jota.marvel.model.mapper;

import com.jota.marvel.domain.model.Comic;
import com.jota.marvel.model.ComicModel;
import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComicModelDataMapperTest extends TestCase {

  private static final int FAKE_ID = 1;
  private static final String FAKE_TITLE = "title";
  private static final String FAKE_DESCRIPTION = "description";
  private static final String FAKE_THUMBNAIL = "thumbnail";

  private ComicModelDataMapper mComicModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    mComicModelDataMapper = new ComicModelDataMapper();
  }

  public void testTransformComic() {
    Comic comic = createFakeComic();
    ComicModel comicModel = mComicModelDataMapper.transform(comic);

    assertThat(comicModel.getId(), is(FAKE_ID));
    assertThat(comicModel.getTitle(), is(FAKE_TITLE));
    assertThat(comicModel.getDescription(), is(FAKE_DESCRIPTION));
    assertThat(comicModel.getThumbnailUrl(), is(FAKE_THUMBNAIL));
  }

  private Comic createFakeComic() {
    Comic comic = new Comic();
    comic.setId(FAKE_ID);
    comic.setTitle(FAKE_TITLE);
    comic.setDescription(FAKE_DESCRIPTION);
    comic.setThumbnailUrl(FAKE_THUMBNAIL);

    return comic;
  }
}
