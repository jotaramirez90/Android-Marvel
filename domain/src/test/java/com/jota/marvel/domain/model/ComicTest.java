package com.jota.marvel.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ComicTest {

  private static final int FAKE_COMIC_ID = 1;
  private static final String FAKE_TITLE = "comicTitle";
  private static final String FAKE_DESCRIPTION = "comicDescription";
  private static final String FAKE_THUMBNAIL = "thumbnailUrl";

  private Comic comic;

  @Before public void setUp() {
    comic = new Comic();
    comic.setId(FAKE_COMIC_ID);
    comic.setTitle(FAKE_TITLE);
    comic.setDescription(FAKE_DESCRIPTION);
    comic.setThumbnailUrl(FAKE_THUMBNAIL);
  }

  @Test public void testComicConstructorHappyCase() {
    assertThat(comic.getId(), is(FAKE_COMIC_ID));
    assertThat(comic.getTitle(), is(FAKE_TITLE));
    assertThat(comic.getDescription(), is(FAKE_DESCRIPTION));
    assertThat(comic.getThumbnailUrl(), is(FAKE_THUMBNAIL));
  }
}
