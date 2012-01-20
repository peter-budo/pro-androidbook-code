package uk.co.peterscorner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class TextViewActivity extends Activity{

    private String[] languages = new String[]{"English", "Hebrew","Hindi" ,"Spanish", "German", "Greek"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);

        TextView tv = (TextView) findViewById(R.id.tv);
        EditText et = (EditText) findViewById(R.id.et);
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.actv);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,languages);
        
        actv.setAdapter(aa);

        MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView)findViewById(R.id.mactv);
        mactv.setAdapter(aa);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
