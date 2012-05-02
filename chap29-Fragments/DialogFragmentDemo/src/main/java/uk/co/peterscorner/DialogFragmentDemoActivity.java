package uk.co.peterscorner;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class DialogFragmentDemoActivity extends FragmentActivity implements OnDialogDoneListener{

    private static String TAG = "dialog-fragment-demo";
    public static String ALERT_DIALOG_TAG = "ALERT_DIALOG_TAG";
    public static String HELP_DIALOG_TAG = "HELP_DIALOG_TAG";
    public static String PROMPT_DIALOG_TAG = "PROMPT_DIALOG_TAG";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        FragmentManager.enableDebugLogging(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_show_alert_dialog){
            this.testAlertDialog();
            return true;
        }
        if(item.getItemId() == R.id.menu_show_prompt_dialog){
            this.testPromptDialog();
            return true;
        }
        if(item.getItemId() == R.id.menu_help){
            this.testHelpDialog();
            return true;
        }
        return false;
    }

    private void testAlertDialog(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        AlertDialogFragment adf = AlertDialogFragment.newInstance("Alert Message");
        adf.show(ft, ALERT_DIALOG_TAG);
    }

    private void testPromptDialog(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        PromptDialogFragment pdf = PromptDialogFragment.newInstance("Enter Something");
        pdf.show(ft, PROMPT_DIALOG_TAG);
    }

    private void testHelpDialog(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        HelpDialogFragment hdf = HelpDialogFragment.newInstance(R.string.help_text);
        hdf.show(ft, HELP_DIALOG_TAG);
    }

    @Override
    public void onDialogDone(String tag, boolean cancelled, CharSequence message) {
        String s = tag + "responds with: " + message;
        if(cancelled)
            s = tag + " was cancelled by the user";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}

