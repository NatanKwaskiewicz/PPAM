package com.example.a2026_11_16;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextSurname, editTextChars;
    Spinner spinner;
    CheckBox checkBoxLetters, checkBoxDigits, checkBoxSpecial;
    Button buttonGeneratePass, buttonConfirm;
    String letters_lower = "abcdefghijklmnoprstuvwyz";
    String letters_upper = "ABCDEFGHIJKLMNOPRSTUVWYZ";
    String special = "!@#$%^&*()_+-=";
    String password = "";

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

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextChars = findViewById(R.id.editTextChars);
        spinner = findViewById(R.id.spinner);
        checkBoxLetters = findViewById(R.id.checkBoxLetters);
        checkBoxDigits = findViewById(R.id.checkBoxDigits);
        checkBoxSpecial = findViewById(R.id.checkBoxSpecial);
        buttonGeneratePass = findViewById(R.id.buttonGeneratePass);
        buttonConfirm = findViewById(R.id.buttonConfirm);

        String[] positions = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, positions);
        spinner.setAdapter(arrayAdapter);

        Random random = new Random();


        buttonGeneratePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = "";
                int password_length = Integer.parseInt(editTextChars.getText().toString());
                if (checkBoxDigits.isChecked())
                {
                    int random_digit = random.nextInt(10);
                    password += random_digit;
                    password_length--;
                }

                if (checkBoxSpecial.isChecked())
                {
                    int random_special = random.nextInt(special.length());
                    password += special.charAt(random_special);
                    password_length--;
                }

                if(checkBoxLetters.isChecked())
                {
                    int random_letter_upper = random.nextInt(letters_upper.length());
                    password += letters_upper.charAt(random_letter_upper);
                    password_length--;
                }

                for (int i = 0; i < password_length; i++){
                    int random_letter = random.nextInt(letters_lower.length());
                    password += letters_lower.charAt(random_letter);
                }

                new AlertDialog.Builder(MainActivity.this).setMessage(password).setPositiveButton("OK", null).show();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String position = spinner.getSelectedItem().toString();
                String info = "Dane pracownika: " + name + " " + surname + " " + position + " Hasło: " + password;
                new AlertDialog.Builder(MainActivity.this).setMessage(info).setPositiveButton("OK", null).show();
            }
        });

    }
}
