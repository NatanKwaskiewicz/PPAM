package com.example.a11_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReportedActivity extends AppCompatActivity {

    TextView reported_name, reported_surname, reported_class;
    Intent nextReport, reportBundle;
    String bundle_name, bundle_surname, bundle_class;
    Button saveNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reported);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        reported_name = findViewById(R.id.reported_name);
        reported_surname = findViewById(R.id.reported_surname);
        reported_class = findViewById(R.id.reported_class);
        saveNoteBtn = findViewById(R.id.save_note_button);

        nextReport = new Intent(ReportedActivity.this, MainActivity.class);
        reportBundle = getIntent();
        bundle_name = reportBundle.getStringExtra("name");
        bundle_surname = reportBundle.getStringExtra("surname");
        bundle_class = reportBundle.getStringExtra("classname");

        reported_name.setText(bundle_name);
        reported_surname.setText(bundle_surname);
        reported_class.setText(bundle_class);

        saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportedActivity.this.finish();
                startActivity(nextReport);
            }
        });

    }
}