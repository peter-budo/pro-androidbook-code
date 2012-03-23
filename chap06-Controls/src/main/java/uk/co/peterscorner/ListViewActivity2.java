package uk.co.peterscorner;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListViewActivity2 extends ListViewActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView lv = getListView();

        Cursor c = managedQuery(Contacts.CONTENT_URI, null, null, null, Contacts.DISPLAY_NAME);
        String[] cols = new String[]{Contacts.DISPLAY_NAME};
        int[] views = new int[]{android.R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c, cols, views);
        this.setListAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View target, int position, long id) {
        Log.v("ListViewActivity2 ", "in onItemClick with " + ((TextView) target).getText() +
                ". Position = " + position + ". Id = " + id);
        Uri selectedPerson = ContentUris.withAppendedId(Contacts.CONTENT_URI, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, selectedPerson);
        startActivity(intent);
    }
}
