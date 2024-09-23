package com.example.bmicaculator;

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

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight, editTextHeight;
    TextView textViewResult, textViewCategory;
    Button buttonCalculateBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        textViewResult = findViewById(R.id.textViewResult);
        textViewCategory = findViewById(R.id.textViewCategory);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextWeight.getText().toString().isEmpty() && !editTextHeight.getText().toString().isEmpty()) {
                    double weight = Double.parseDouble(editTextWeight.getText().toString());
                    double height = Double.parseDouble(editTextHeight.getText().toString());

                    if (height > 0) {
                        double bmi = calculateBMI(weight, height);
                        textViewResult.setText(String.format("BMI: %.2f", bmi));
                        textViewCategory.setText("Phân loại: " + getBMICategory(bmi));
                    } else {
                        Toast.makeText(MainActivity.this, "Chiều cao phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập khối lượng và chiều cao", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm tính toán chỉ số BMI
    private double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Hàm phân loại BMI theo giá trị tính được
    private String getBMICategory(double bmi) {
        if (bmi < 18) {
            return "Người gầy";
        } else if (bmi >= 18 && bmi <= 24.9) {
            return "Người bình thường";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Người béo phì độ I";
        } else if (bmi >= 30 && bmi <= 34.9) {
            return "Người béo phì độ II";
        } else {
            return "Người béo phì độ III";
        }
    }
}