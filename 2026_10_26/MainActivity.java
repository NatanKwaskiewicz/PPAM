package zsk.edu.a2026_10_26;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button buttonCipher, buttonSaveToFile;
    TextView textViewResult;
    EditText editTextKey, editTextInputText;
    static String resultText = "";

    private static String CaesarCipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        char[] textArray = text.toCharArray();
        int offset = key % 26;
        for(int i = 0; i < text.length(); i++)
        {
            if(textArray[i] >= 'a' && textArray[i] <= 'z') {
                char shifted = (char) ('a' + (textArray[i] - 'a' + offset + 26) % 26);
                result.append(shifted);
            }
            else {
                result.append(textArray[i]);
            }
        }
        resultText = result.toString();
        return resultText;
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

        buttonCipher = findViewById(R.id.buttonCipher);
        buttonSaveToFile = findViewById(R.id.buttonSaveToFile);
        textViewResult = findViewById(R.id.textViewResult);
        editTextKey = findViewById(R.id.editTextKey);
        editTextInputText = findViewById(R.id.editTextInputText);

        buttonCipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInputText.getText().toString();
                String keyText = editTextKey.getText().toString();
                int key = Integer.parseInt(keyText);
                String ciphered = CaesarCipher(inputText, key);
                textViewResult.setText(ciphered);
            }
        });

        buttonSaveToFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (FileOutputStream fos = openFileOutput("ciphered_text.txt", MODE_PRIVATE)) {
                    fos.write(resultText.getBytes(StandardCharsets.UTF_8));
                    Toast.makeText(MainActivity.this, "Zapisano plik", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Błąd podczas zapisywania pliku", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

}
