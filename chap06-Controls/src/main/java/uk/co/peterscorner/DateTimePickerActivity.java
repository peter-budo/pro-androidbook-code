package uk.co.peterscorner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Formatter;

public class DateTimePickerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetimepicker);

        TextView dateDefault = (TextView) findViewById(R.id.dateDefault);
        TextView timeDefault = (TextView) findViewById(R.id.timeDefault);

        DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        dateDefault.setText("Date default to "
                + (dp.getMonth() + 1)
                + "/"
                + (dp.getDayOfMonth())
                + "/"
                + (dp.getYear()));
        
        dp.init(2012, 0, 24, null);

        TimePicker tp = (TimePicker) findViewById(R.id.timePicker);
        Formatter timeF = new Formatter();
        timeF.format("Time default to %d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());
        timeDefault.setText(timeF.toString());

        tp.setIs24HourView(true);
        tp.setCurrentHour(15);
        tp.setCurrentMinute(16);

    }
}