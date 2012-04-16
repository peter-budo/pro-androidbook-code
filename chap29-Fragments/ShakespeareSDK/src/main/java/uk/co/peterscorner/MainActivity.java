package uk.co.peterscorner;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import co.uk.peterscorner.R;

public class MainActivity extends FragmentActivity {

    public static final String TAG = "ShakespeareSDK";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, " in MainActivity onCreate");
        FragmentManager.enableDebugLogging(true);
        setContentView(R.layout.main);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.v(TAG, " in MainActivity onAttachFragment. Fragment id = " + fragment.getId());
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean isMultiPane() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public void showDetails(int index) {
        Log.v(TAG, "in MainActivity showDetails(" + index + ")");

        if (isMultiPane()) {
            // Check what fragment is shown, replace if needed.
            DetailsFragment details = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details);
            if (details == null || details.getShownIndex() != index) {
                details = DetailsFragment.newInstance(index);
                Log.v(TAG, "about to run FragmentTransaction...");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.details, details);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(this, DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);

        }
    }
}

