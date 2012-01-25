package uk.co.peterscorner;

import android.R;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
/*import android.provider.Contacts.People;*/    //Deprecated use ContactsContract with Contacts
import android.provider.ContactsContract.Contacts;
import android.widget.SimpleCursorAdapter;

public class ListViewActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Cursor c = managedQuery(People.CONTENT_URI, null, null, null, People.NAME);
        String[] cols = new String[]{People.NAME};*/
        //Above code deprecated use bellow code
        Cursor c = managedQuery(Contacts.CONTENT_URI, null, null, null, Contacts.DISPLAY_NAME);
        String[] cols = new String[] {Contacts.DISPLAY_NAME};
        int[] views = new int[]{R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.simple_list_item_1, c, cols, views);
        this.setListAdapter(adapter);
    }
}
