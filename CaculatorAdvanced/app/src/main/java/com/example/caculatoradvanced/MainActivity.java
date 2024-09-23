package com.example.caculatoradvanced;

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

    EditText editTextNumber1, editTextNumber2;
    TextView textViewResult;
    Button buttonSum, buttonSubtract, buttonMultiply, buttonDivide, buttonGCD, buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSum = findViewById(R.id.buttonSum);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonGCD = findViewById(R.id.buttonGCD);
        buttonExit = findViewById(R.id.buttonExit);

        // Tính tổng
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = getNumber(editTextNumber1);
                double num2 = getNumber(editTextNumber2);
                double result = num1 + num2;
                textViewResult.setText("Tổng: " + result);
            }
        });

        // Tính hiệu
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = getNumber(editTextNumber1);
                double num2 = getNumber(editTextNumber2);
                double result = num1 - num2;
                textViewResult.setText("Hiệu: " + result);
            }
        });

        // Tính tích
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = getNumber(editTextNumber1);
                double num2 = getNumber(editTextNumber2);
                double result = num1 * num2;
                textViewResult.setText("Tích: " + result);
            }
        });

        // Tính thương
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = getNumber(editTextNumber1);
                double num2 = getNumber(editTextNumber2);
                if (num2 != 0) {
                    double result = num1 / num2;
                    textViewResult.setText("Thương: " + result);
                } else {
                    textViewResult.setText("Không thể chia cho 0");
                }
            }
        });

        // Tính ước chung lớn nhất
        buttonGCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = (int) getNumber(editTextNumber1);
                int num2 = (int) getNumber(editTextNumber2);
                int result = gcd(num1, num2);
                textViewResult.setText("Ước chung lớn nhất: " + result);
            }
        });

        // Thoát chương trình
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Hàm lấy số từ EditText
    private double getNumber(EditText editText) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Double.parseDouble(text);
    }

    // Hàm tính ước chung lớn nhất (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}