package uk.co.peterscorner;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HelpDialogFragment extends DialogFragment implements View.OnClickListener {

    public static HelpDialogFragment newInstance(int help_text) {
        HelpDialogFragment hdf = new HelpDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("help_resource", help_text);
        hdf.setArguments(bundle);
        return hdf;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setCancelable(true);
        int style = DialogFragment.STYLE_NORMAL, theme= 0;
        setStyle(style, theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.help_dialog, container, false);
        TextView tv = (TextView) v.findViewById(R.id.helpmessage);
        tv.setText(getActivity().getResources().getText(getArguments().getInt("help_resource")));
        Button closeBtn = (Button)v.findViewById(R.id.btn_close);
        closeBtn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
