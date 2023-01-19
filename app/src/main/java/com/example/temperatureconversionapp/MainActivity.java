package com.example.temperatureconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button ClearButton;
    EditText TextBoxC;
    EditText TextBoxF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClearButton = findViewById(R.id.ClearButton);
        TextBoxC = findViewById(R.id.TextBoxC);
        TextBoxF = findViewById(R.id.TextBoxF);

        ClearButton.setOnClickListener(v -> {
            TextBoxC.setText("");
            TextBoxF.setText("");
        });

        TextBoxC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (TextBoxC.isFocused()) {
                    if (TextBoxC.getText().toString().length() > 0) {
                        double c = Double.parseDouble(TextBoxC.getText().toString());
                        double f = c * 9 / 5 + 32;
                        f = Math.round(f * 100.0) / 100.0;

                        TextBoxF.setText(String.valueOf(f));
                    } else {
                        TextBoxF.setText("");
                    }
                }
            }
        });

        TextBoxF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (TextBoxF.isFocused()) {
                    if (TextBoxF.getText().toString().length() > 0) {
                        double f = Double.parseDouble(TextBoxF.getText().toString());
                        double c = (f - 32) * 5 / 9;
                        c = Math.round(c * 100.0) / 100.0;

                        TextBoxC.setText(String.valueOf(c));
                    } else {
                        TextBoxC.setText("");
                    }
                }
            }
        });
    }
}