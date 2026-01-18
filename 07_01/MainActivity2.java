package com.example.a07_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView textEmail;
    Button btn;
    Intent loginScreen;
    Intent emailBundle;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textEmail = findViewById(R.id.textEmail);
        btn = findViewById(R.id.buttonLogout);
        loginScreen = new Intent(this, MainActivity.class);
        emailBundle = getIntent();
        email = emailBundle.getStringExtra("email");

        if (email==null)
        {
            email = "examplegmail.com";
        }
        textEmail.setText(email);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(loginScreen);
                finish();
            }
        });

    }
}
