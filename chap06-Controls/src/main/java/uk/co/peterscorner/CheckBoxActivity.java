package uk.co.peterscorner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);

        CheckBox fishCB = (CheckBox) findViewById(R.id.fishCB);
        if (fishCB.isChecked())
            fishCB.toggle();

        fishCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.v("CheckBoxActivity", "The fish checkbox is now" + (isChecked ? "checked" : "not checked"));
            }
        });
    }
}
