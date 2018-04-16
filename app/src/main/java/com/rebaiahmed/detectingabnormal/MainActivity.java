package com.rebaiahmed.detectingabnormal;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView seekBarValue;
    EditText value;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        mHandler = new Handler(getApplicationContext().getMainLooper());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                final int progress = i;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        seekBarValue = (TextView) findViewById(R.id.seekBarValue);
                        seekBarValue.setText("" + progress);
                        value = (EditText) findViewById(R.id.seekValue);
                        value.setText(""+progress);
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
