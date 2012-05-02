package uk.co.peterscorner;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PromptDialogFragment extends DialogFragment implements View.OnClickListener {
    private EditText et;

    public static PromptDialogFragment newInstance(String prompt){
        PromptDialogFragment pdf = new PromptDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("prompt", prompt);
        pdf.setArguments(bundle);
        return pdf;
    }

    @Override
    public void onAttach(Activity activity) {
        OnDialogDoneListener test = (OnDialogDoneListener) activity;
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        setStyle(style, theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.prompt_dialog, container, false);
        TextView tv = (TextView)v.findViewById(R.id.promptmessage);
        tv.setText(getArguments().getString("prompt"));

        Button dismissButton = (Button) v.findViewById(R.id.btn_dismiss);
        dismissButton.setOnClickListener(this);

        Button saveButton = (Button) v.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(this);

        Button helpButton = (Button) v.findViewById(R.id.btn_help);
        helpButton.setOnClickListener(this);

        et = (EditText)v.findViewById(R.id.inputtext);
        if(savedInstanceState != null)
            et.setText(savedInstanceState.getCharSequence("input"));
        return v;
    }

    @Override
    public void onClick(View view) {
        OnDialogDoneListener act = (OnDialogDoneListener)getActivity();
        if(view.getId() == R.id.btn_save){
            TextView tv = (TextView)getView().findViewById(R.id.inputtext);
            act.onDialogDone(this.getTag(), false, tv.getText());
            dismiss();
            return;
        }
        if(view.getId() == R.id.btn_dismiss){
            act.onDialogDone(this.getTag(), true, null);
            dismiss();
            return;
        }
        if(view.getId() == R.id.btn_help){
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.remove(this);
            HelpDialogFragment hdf = HelpDialogFragment.newInstance(R.string.help1);
            hdf.show(ft, DialogFragmentDemoActivity.HELP_DIALOG_TAG);
            return;
        }
    }
}

