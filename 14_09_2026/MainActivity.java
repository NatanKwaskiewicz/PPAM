package com.example.a14_09_2026;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_zatwierdz, btn_wlacz;
    EditText editText_number;
    TextView textView_numerPrania, textView_odkurzacz;

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

        btn_zatwierdz = findViewById(R.id.buttonZatwierdz);
        btn_wlacz = findViewById(R.id.buttonWlacz);
        editText_number = findViewById(R.id.editTextNumber);
        textView_numerPrania = findViewById(R.id.textViewNumerPrania);
        textView_odkurzacz = findViewById(R.id.textViewOdkurzacz);

        String btn_wlacz_text = btn_wlacz.getText().toString();

        btn_zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.getInteger(editText_number.getText().toString());

                if (number >= 1 && number <= 12){
                    textView_numerPrania.setText("Numer prania: " + number);
                }
            }
        });

        btn_wlacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_wlacz_text.equals("Włącz")) {
                    btn_wlacz.setText("Wyłącz");
                    textView_odkurzacz.setText("Odkurzacz włączony");
                } else {
                    btn_wlacz.setText("Włącz");
                    textView_odkurzacz.setText("Odkurzacz wyłączony");
                }
            }
        });
    }
}