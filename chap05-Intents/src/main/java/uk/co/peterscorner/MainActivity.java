package uk.co.peterscorner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";

    Menu myMenu = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setupButton();
        this.setupEditText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        MenuInflater mi = this.getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try{
            handleMenus(item);
        } catch (Throwable t){
            Log.d(TAG, t.getMessage(), t);
            throw new RuntimeException("error", t);
        }
        return true;
    }

    private void handleMenus(MenuItem item){
        this.appendMenuItemText(item);
        if(item.getItemId() == R.id.menu_clear){
            this.emptyText();
        } else if(item.getItemId() == R.id.menu_basic_view){
            IntentUtils.invokeBasicActivity(this);
        } else if(item.getItemId() == R.id.menu_show_browser) {
            IntentUtils.invokeWebBrowser(this);
        }else if(item.getItemId() == R.id.menu_search){
            IntentUtils.invokeWebSearch(this);
        } else if (item.getItemId() == R.id.menu_dial){
            IntentUtils.dial(this);
        } else if (item.getItemId() == R.id.menu_call){
            IntentUtils.call(this);
        } else if (item.getItemId() == R.id.menu_map){
            IntentUtils.showMapAtLatLong(this);
        } else if (item.getItemId() == R.id.menu_testPick) {
            IntentUtils.invokePick(this);
        }  else if (item.getItemId() == R.id.menu_testGetContent){
            IntentUtils.invokeGetContent(this);
        }
    }

    private TextView getTextView(){
        TextView tv = (TextView) this.findViewById(R.id.textViewId);
        return tv;
    }

    public void appendText(String text){
        TextView tv = (TextView)this.findViewById(R.id.textViewId);
        tv.setText(tv.getText() + text);
    }

    public void appendMenuItemText(MenuItem menuItem){
        String title = menuItem.getTitle().toString();
        TextView tv = (TextView)this.findViewById(R.id.textViewId);
        tv.setText(tv.getText() + "\n" + title + ":" + menuItem.getItemId());
    }

    private void emptyText(){
        TextView tv = (TextView) this.findViewById(R.id.textViewId);
        tv.setText("");
    }

    private void dial(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    private void setupButton(){
        Button b = (Button)this.findViewById(R.id.button1);
        b.setOnClickListener(
            new Button.OnClickListener(){

                public void onClick(View view) {
                    parentButtonClicked(view);
                }
            }
        );
    }

    private void parentButtonClicked(View v){
        this.appendText("\nbutton clicked");
        this.dialUsingEditText();
    }

    private void dialWithNumber(String tel){
        String telUriString = "tel:" + tel;
        Log.d(TAG, telUriString);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(telUriString));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    private void dialUsingEditText(){
        EditText etext = (EditText)this.findViewById(R.id.editTextId);
        String text = etext.getText().toString();
        if(PhoneNumberUtils.isGlobalPhoneNumber(text) == true){
            dialWithNumber(text);
        }
    }

    private EditText getEditText(){
        return (EditText) this.findViewById(R.id.editTextId);
    }

    private void setupEditText(){
        EditText etext = this.getEditText();
        etext.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent outputIntent){
        super.onActivityResult(requestCode, resultCode, outputIntent);
        IntentUtils.parseResult(this, requestCode, resultCode, outputIntent);
    }
}

