package edu.zsk.a01_04;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    Intent secondActivity, thirdActivity;
    PendingIntent pendingIntent;
    NotificationManager notificationManager;
    NotificationChannel highChannel, lowChannel;
    Notification notification;
    String CHANNEL_ID_LOW = "channel_low";
    String CHANNEL_ID_HIGH = "channel_high";
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

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        secondActivity = new Intent(this, MainActivity2.class);
        thirdActivity = new Intent(this, MainActivity3.class);


        notificationManager = getSystemService(NotificationManager.class);

        highChannel = new NotificationChannel(
                CHANNEL_ID_HIGH, "High Priority", NotificationManager.IMPORTANCE_HIGH);
        lowChannel = new NotificationChannel(
                CHANNEL_ID_LOW, "Low Priority", NotificationManager.IMPORTANCE_LOW);

        notificationManager.createNotificationChannel(highChannel);
        notificationManager.createNotificationChannel(lowChannel);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, secondActivity,
                                PendingIntent.FLAG_IMMUTABLE);

                notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID_HIGH)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Powiadomienie")
                        .setContentText("Do aktywności 2")
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();
                int id = 1;
                notificationManager.notify(id, notification);
            }
        });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pendingIntent =
                            PendingIntent.getActivity(MainActivity.this, 1, thirdActivity,
                                    PendingIntent.FLAG_IMMUTABLE);

                    notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID_LOW)
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle("Powiadomienie")
                            .setContentText("Do aktywności 3")
                            .setContentIntent(pendingIntent)
                            .setPriority(NotificationCompat.PRIORITY_LOW)
                            .build();
                    int id = 2;
                    notificationManager.notify(id, notification);
                }
        });
    }
}