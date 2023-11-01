package com.example.circumference2page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private int requestCode;
    private double radius; // Variable to store the radius

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        requestCode = getIntent().getIntExtra("requestCode", 0);
        radius = getIntent().getDoubleExtra("radius", 0.0); // Get the radius value

        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = calculateResult(requestCode, radius); // Pass the radius to the calculation
                returnResult(result);
            }
        });
    }

    private double calculateResult(int requestCode, double radius) {
        if (requestCode == 1) {
            // Calculate circumference
            return 2 * Math.PI * radius;
        } else {
            // Calculate area
            return Math.PI * radius * radius;
        }
    }

    private void returnResult(double result) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", result);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
