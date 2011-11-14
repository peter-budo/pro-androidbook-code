package uk.co.peterscorner.test;

import android.test.ActivityInstrumentationTestCase2;
import org.junit.Ignore;
import uk.co.peterscorner.BookProviderActivity;

@Ignore
public class BookProviderActivityTest extends ActivityInstrumentationTestCase2<BookProviderActivity> {

    public BookProviderActivityTest() {
        super("uk.co.peterscorner", BookProviderActivity.class);
    }

    public void testActivity() {
        BookProviderActivity activity = getActivity();
        assertNotNull(activity);
    }
}

