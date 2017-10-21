package jp.azusatechacademy.sugimoto.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int time = 2;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        } else if ((time >= 2) && (time <= 9)) {
            mTextView.setText("おはよう");
        } else if ((time >= 10) && (time <= 17)) {
            mTextView.setText("こんにちは");
        } else {
            mTextView.setText("こんばんは");
        }

    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }
}
