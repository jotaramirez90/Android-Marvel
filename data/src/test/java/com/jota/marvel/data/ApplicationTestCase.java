package com.jota.marvel.data;

import com.jota.marvel.dataEntity.BuildConfig;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = "src/main/AndroidManifest.xml",
    application = ApplicationStub.class, sdk = 21) public abstract class ApplicationTestCase {
}
