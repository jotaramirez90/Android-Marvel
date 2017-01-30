package com.jota.marvel.ui.main.view;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.jota.marvel.R;
import com.jota.marvel.ui.features.main.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

  private MainActivity mMainActivity;

  public MainActivityTest() {
    super(MainActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    mMainActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsProperTitle() {
    String actualTitle = this.mMainActivity.getTitle().toString().trim();
    assertThat(actualTitle, is(mMainActivity.getString(R.string.app_name)));
  }

  public void testLoadSplashActivityHappyCaseViews() {
    onView(withId(R.id.comicsFrame)).check(matches(isDisplayed()));
  }

  private Intent createTargetIntent() {
    Intent intentToLaunch = MainActivity.getCallingIntent(getInstrumentation().getTargetContext());
    return intentToLaunch;
  }
}
