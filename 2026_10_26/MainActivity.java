package zsk.edu.a2026_10_26;

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

    Button buttonCipher, buttonSaveToFile;
    TextView textViewResult;
    EditText editTextKey, editTextInputText;
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

        buttonCipher = findViewById(R.id.buttonCipher);
        buttonSaveToFile = findViewById(R.id.buttonSaveToFile);
        textViewResult = findViewById(R.id.textViewResult);
        editTextKey = findViewById(R.id.editTextKey);
        editTextInputText = findViewById(R.id.editTextInputText);

        buttonCipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInputText.getText().toString();
            }
        });
    }
}