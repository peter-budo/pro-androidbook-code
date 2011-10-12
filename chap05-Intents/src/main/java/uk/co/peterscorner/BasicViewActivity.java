package uk.co.peterscorner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BasicViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_view);
        Intent intent = this.getIntent();
        if (intent == null) {
            Log.d("test tag", "This activity is invoked without an intent");
        }
    }
}
