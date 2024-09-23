package com.example.convertapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextCelsius, editTextKelvin;
    Button buttonCtoK, buttonKtoC, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextKelvin = findViewById(R.id.editTextKelvin);
        buttonCtoK = findViewById(R.id.buttonCtoK);
        buttonKtoC = findViewById(R.id.buttonKtoC);
        buttonClear = findViewById(R.id.buttonClear);

        // Chuyển đổi từ Celsius sang Kelvin
        buttonCtoK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextCelsius.getText().toString().isEmpty()) {
                    double celsius = Double.parseDouble(editTextCelsius.getText().toString());
                    double kelvin = celsiusToKelvin(celsius);
                    editTextKelvin.setText(String.valueOf(kelvin));
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập nhiệt độ Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Chuyển đổi từ Kelvin sang Celsius
        buttonKtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextKelvin.getText().toString().isEmpty()) {
                    double kelvin = Double.parseDouble(editTextKelvin.getText().toString());
                    double celsius = kelvinToCelsius(kelvin);
                    editTextCelsius.setText(String.valueOf(celsius));
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập nhiệt độ Kelvin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nút xóa dữ liệu
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCelsius.setText("");
                editTextKelvin.setText("");
            }
        });
    }

    // Hàm chuyển đổi từ Celsius sang Kelvin
    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Hàm chuyển đổi từ Kelvin sang Celsius
    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}