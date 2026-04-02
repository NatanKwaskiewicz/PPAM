package com.example.a18_03;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayAdapter<String> adapter;
    Button btn;
    SeekBar seekBar;
    ArrayList<String> animals;
    TextView age, result;
    EditText name_input, aim_input, time_input;
    String selectedAnimal = "Nie wybrano", name, age_value, aim, time;
    NotificationManager notificationManager;
    NotificationChannel channel;
    Notification notification;
    String CHANNEL_ID = "channel_id";
    String CHANNEL_NAME = "My Channel";


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

        list = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);
        btn = findViewById(R.id.button);
        age = findViewById(R.id.textView6);
        name_input = findViewById(R.id.editTextText);
        aim_input = findViewById(R.id.editTextText2);
        time_input = findViewById(R.id.editTextTime);
        result = findViewById(R.id.textView8);

        animals = new ArrayList<>();
        animals.add("Pies");
        animals.add("Kot");
        animals.add("Świnka morska");
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, animals);
        list.setAdapter(adapter);

        notificationManager = getSystemService(NotificationManager.class);

        channel = new NotificationChannel(
                CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_HIGH);

       notificationManager.createNotificationChannel(channel);


        list.setOnItemClickListener((parent, view, position, id) -> {
            selectedAnimal = animals.get(position);
            switch (selectedAnimal) {
                case "Pies":
                    seekBar.setMax(18);
                    break;
                case "Kot":
                    seekBar.setMax(20);
                    break;
                case "Świnka morska":
                    seekBar.setMax(9);
                    break;
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = name_input.getText().toString();
                age_value = String.valueOf(seekBar.getProgress());
                aim = aim_input.getText().toString();
                time = time_input.getText().toString();

                String result_text =
                        name + ", " +
                        selectedAnimal + ", " +
                        age_value + ", " +
                        aim + ", " +
                        time;

                result.setText(result_text);

                notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Powiadomienie")
                        .setContentText(result_text)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();

                notificationManager.notify(0, notification);
            }
        });
    }
}