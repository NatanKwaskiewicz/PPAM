package com.example.a11_02;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText input_name, input_surname, input_class;
    Intent report;
    Bundle report_params;

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

        btn = findViewById(R.id.save_note_button);
        input_name = findViewById(R.id.name_input);
        input_surname = findViewById(R.id.surname_input);
        input_class = findViewById(R.id.class_input);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input_name.getText().toString();
                String surname = input_name.getText().toString();
                String classname = input_name.getText().toString();

                if(name.isBlank() || surname.isBlank() || classname.isBlank())
                {
                    Toast.makeText(MainActivity.this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                }
                else {
                    report = new Intent(MainActivity.this, ReportedActivity.class);
                    report_params = new Bundle();
                    report_params.putString("name", name);
                    report_params.putString("surname", surname);
                    report_params.putString("classname", classname);
                }
            }
        });

    }
}