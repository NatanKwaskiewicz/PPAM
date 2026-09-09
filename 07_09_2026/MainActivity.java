package com.example.a07_09_2026;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_throw, btn_reset;
    Integer random_number;
    ImageView img1, img2, img3, img4, img5;
    TextView wynikLos, wynikGra;

    int wynik_gry = 0;

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

        btn_throw = findViewById(R.id.button_throw);
        btn_reset = findViewById(R.id.button_reset);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        wynikLos = findViewById(R.id.textViewWynikLos);
        wynikGra = findViewById(R.id.textViewWynikGra);

        ImageView[] zdjecia = {
                img1,
                img2,
                img3,
                img4,
                img5
        };

        int[] kostki = {
                R.drawable.k1,
                R.drawable.k2,
                R.drawable.k3,
                R.drawable.k4,
                R.drawable.k5,
                R.drawable.k6
        };

        Random random = new Random();

        btn_throw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wynik_losowania = 0;
                for (int i=0;i<5;i++) {
                    random_number = random.nextInt(6)+1;
                    zdjecia[i].setImageResource(kostki[random_number-1]);
                    wynik_losowania+=random_number;
                    wynikLos.setText("Wynik tego losowania: " + wynik_losowania);
                    wynik_gry += random_number;
                    wynikGra.setText("Wynik gry: " + wynik_gry);

                }

            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<5;i++) {
                    zdjecia[i].setImageResource(R.drawable.question);
                    wynikLos.setText("Wynik tego losowania:");
                    wynik_gry=0;
                    wynikGra.setText("Wynik gry:");
                }
            }
        });


    }
}