package com.example.a2026_11_02_v2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.MutableLiveData;

public class MainActivity extends AppCompatActivity {

    View view;
    TextView textViewRedValue, textViewGreenValue, textViewBlueValue, textViewRGB;
    SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    Button buttonConfirm;
    int red = 255, green = 255, blue = 255;
    final MutableLiveData<Integer> red_value = new MutableLiveData<>(255);
    final MutableLiveData<Integer> green_value = new MutableLiveData<>(255);
    final MutableLiveData<Integer> blue_value = new MutableLiveData<>(255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        view = findViewById(R.id.view);
        textViewRedValue = findViewById(R.id.textViewRedValue);
        textViewGreenValue = findViewById(R.id.textViewGreenValue);
        textViewBlueValue = findViewById(R.id.textViewBlueValue);
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        textViewRGB = findViewById(R.id.textViewRGB);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewRedValue.setText(String.valueOf(progress));
                red = progress;
                red_value.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewGreenValue.setText(String.valueOf(progress));
                green = progress;
                green_value.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewBlueValue.setText(String.valueOf(progress));
                blue = progress;
                blue_value.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        red_value.observe(this, newValue -> {
            view.setBackgroundColor(Color.rgb(newValue, green, blue));
        });

        green_value.observe(this, newValue -> {
            view.setBackgroundColor(Color.rgb(red, newValue, blue));
        });

        blue_value.observe(this, newValue -> {
            view.setBackgroundColor(Color.rgb(red, green, newValue));
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewRGB.setText(red + ", " + green + ", " + blue);
                textViewRGB.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

    }
}