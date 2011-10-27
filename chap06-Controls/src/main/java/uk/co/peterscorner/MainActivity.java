package uk.co.peterscorner;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity{

    private LinearLayout nameContainer;
    private LinearLayout addressContainer;
    private LinearLayout parentContainer;

    /** Called when the activity is first started. */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        createNameContainer();
        createAddressContainer();
        createParentContainer();
        setContentView(parentContainer);
    }

    private void createNameContainer() {
        nameContainer = new LinearLayout(this);
        nameContainer.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        nameContainer.setOrientation(LinearLayout.HORIZONTAL);
        TextView nameLabel = new TextView(this);
        nameLabel.setText("Name: ");

        TextView nameValue = new TextView(this);
        nameValue.setText("John Doe");

        nameContainer.addView(nameLabel);
        nameContainer.addView(nameValue);
    }

    private void createAddressContainer() {
        addressContainer = new LinearLayout(this);
        addressContainer.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addressContainer.setOrientation(LinearLayout.VERTICAL);

        TextView addressLabel = new TextView(this);
        addressLabel.setText("Address:");

        TextView addressValue = new TextView(this);
        addressValue.setText("911 Hollywood Blvd");

        addressContainer.addView(addressLabel);
        addressContainer.addView(addressValue);
    }

    private void createParentContainer() {
        parentContainer = new LinearLayout(this);

        parentContainer.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        parentContainer.setOrientation(LinearLayout.VERTICAL);

        parentContainer.addView(nameContainer);
        parentContainer.addView(addressContainer);
    }
}
