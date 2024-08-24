package com.example.caculatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.caculatorapp.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_cong;
    private Button btn_tru;
    private Button btn_nhan;
    private Button btn_chia;
    private Button btn_lay_du;

    private EditText edt_input1;
    private EditText edt_input2;
    private EditText edt_kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        loadView();

        // Cài đặt sự kiện cho các nút
        btn_cong.setOnClickListener(view -> performCalculation("+"));
        btn_tru.setOnClickListener(view -> performCalculation("-"));
        btn_nhan.setOnClickListener(view -> performCalculation("*"));
        btn_chia.setOnClickListener(view -> performCalculation("/"));
        btn_lay_du.setOnClickListener(view -> performCalculation("%"));
    }

    private void loadView() {
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_chia = findViewById(R.id.btn_chia);
        btn_lay_du = findViewById(R.id.btn_lay_du);
        edt_input1 = findViewById(R.id.edt_input1);
        edt_input2 = findViewById(R.id.edt_input2);
        edt_kq = findViewById(R.id.edt_kq);
    }

    private void performCalculation(String operation) {
        String strInput1 = edt_input1.getText().toString().trim();
        String strInput2 = edt_input2.getText().toString().trim();

        if (!strInput1.isEmpty() && !strInput2.isEmpty()) {
            double num1 = Double.parseDouble(strInput1);
            double num2 = Double.parseDouble(strInput2);
            double result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        edt_kq.setText("Lỗi: chia cho 0");
                        return;
                    }
                    break;
                case "%":
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        edt_kq.setText("Lỗi: chia cho 0");
                        return;
                    }
                    break;
            }

            edt_kq.setText(String.valueOf(result));
        } else {
            edt_kq.setText("Vui lòng nhập số hợp lệ.");
        }
    }
}
