package uk.co.peterscorner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment implements DialogInterface.OnClickListener{

    public static AlertDialogFragment newInstance(String message){
        AlertDialogFragment adf = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("alert-message", message);
        adf.setArguments(bundle);
        return adf;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setCancelable(true);
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        setStyle(style, theme);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Alert!!");
        builder.setPositiveButton("Ok", this);
        builder.setNegativeButton("Cancel", this);
        builder.setMessage(this.getArguments().getString("alert-message"));
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        OnDialogDoneListener act = (OnDialogDoneListener) getActivity();
        boolean cancelled = false;
        if(i == AlertDialog.BUTTON_NEGATIVE){
            cancelled = true;
        }
        act.onDialogDone(getTag(), cancelled, "Alert dismissed");
    }
}
