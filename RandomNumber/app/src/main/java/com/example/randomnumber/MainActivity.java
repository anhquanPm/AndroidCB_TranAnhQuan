package com.example.randomnumber;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView edt_number;
    private Button btn_random;

    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        loadVIew();

        btn_random.setOnClickListener(view -> {
            int res = random.nextInt(6) + 1;
            edt_number.setText(res+"");

        });
    }

    private void loadVIew(){
       edt_number = findViewById(R.id.edt_number);
       btn_random = findViewById(R.id.btn_random);

    }


}