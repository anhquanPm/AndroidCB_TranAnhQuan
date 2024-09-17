package com.example.randomanimal;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView img_animal;
     private RelativeLayout layout;

    int[] images = {R.drawable.cat, R.drawable.dog, R.drawable.hamster, R.drawable.penguin, R.drawable.turtle};
    int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.GRAY};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_animal = findViewById(R.id.img_animal);
        layout = findViewById(R.id.main);
        Random random = new Random();
        int randomColor = colors[random.nextInt(colors.length)];
        layout.setBackgroundColor(randomColor);

        int randomImage = images[random.nextInt(images.length)];
        img_animal.setImageResource(randomImage);


    }
}