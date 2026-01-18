package com.example.a07_01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editTextEmail,editTextPassword,editTextPassword2;
    TextView textDisplay;
    Intent loggedIn;
    Bundle logParameters;

    static boolean checkRegex(String regex, String string) {
        return string.matches(regex);
    }

    public void errorText(String message) {
        textDisplay.setTextColor(Color.parseColor("#FF0000"));
        textDisplay.setText(message);
    }

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

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPassword2 = findViewById(R.id.editTextPassword2);
        btn = findViewById(R.id.button);
        textDisplay = findViewById(R.id.textView);
        loggedIn = new Intent(this, MainActivity2.class);
        logParameters = new Bundle();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String pass1 = editTextPassword.getText().toString();
                String pass2 = editTextPassword2.getText().toString();
                if (checkRegex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email))
                {
                    logParameters.putString("email", email);
                    loggedIn.putExtras(logParameters);
                    if(checkRegex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*()_/|]{8,}$", pass1))
                    {
                        if(pass1.equals(pass2))
                        {
                            startActivity(loggedIn);
                        }
                        else
                        {
                            errorText("Hasła się różnią");
                        }
                    }
                    else {
                        errorText("Hasło nie spełnia wymagań");
                    }
                }
                else {
                    errorText("Nieprawidłowy adres email");
                }
            }
        });
    }
}
