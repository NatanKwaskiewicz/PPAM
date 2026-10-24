package com.example.a2026_10_19;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView_animals;
    SeekBar seekBar;
    TextView textView_age, textView_result;
    Button button_ok;
    EditText editText_name, editText_reason, editText_time;
    String selected_animal = "";

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

        listView_animals = findViewById(R.id.listViewAnimals);
        seekBar = findViewById(R.id.seekBar);
        textView_age = findViewById(R.id.textViewAge);
        textView_result = findViewById(R.id.textViewResult);
        button_ok = findViewById(R.id.buttonOk);
        editText_name = findViewById(R.id.editTextName);
        editText_reason = findViewById(R.id.editTextReason);
        editText_time = findViewById(R.id.editTextTime);

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Pies");
        animals.add("Kot");
        animals.add("Świnka morska");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        listView_animals.setAdapter(adapter);

        listView_animals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_animal = listView_animals.getItemAtPosition(position).toString();
                switch (selected_animal) {
                    case "Pies":
                        seekBar.setMax(18);
                        if (seekBar.getProgress() > 18) seekBar.setProgress(18);
                        break;
                    case "Kot":
                        seekBar.setMax(20);
                        break;
                    case "Świnka morska":
                        seekBar.setMax(9);
                        if (seekBar.getProgress() > 9) seekBar.setProgress(9);
                        break;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView_age.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getText().toString();
                String reason = editText_reason.getText().toString();
                String animal_kind = selected_animal;
                String age = Integer.toString(seekBar.getProgress());
                String time = editText_time.getText().toString();

                List<String> result_list = Arrays.asList(name, animal_kind, age, reason, time);
                String result = String.join(", ", result_list);

                textView_result.setText(result);
            }
        });
    }
}