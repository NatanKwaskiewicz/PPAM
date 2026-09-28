package edu.zsk.a28_09;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ListView listView;
    EditText editText;
    List<String> notes;
    ArrayAdapter<String> notes_adapter;

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

        notes = new ArrayList<>();

        btn = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextText);

        notes.add("Zakupy: chleb, masło, ser");
        notes.add("Do zrobienia: obiad, umyć podłogi");
        notes.add("weekend: kino, spacer z psem");

        notes_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(notes_adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_input = editText.getText().toString();
                notes.add(text_input);
                notes_adapter.notifyDataSetChanged();
            }
        });

    }
}