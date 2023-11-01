package com.example.circumference;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText radiusEditText;
    ToggleButton toggleButton;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiusEditText = findViewById(R.id.editRadius);
        toggleButton = findViewById(R.id.toggleCalculation);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplay();
            }
        });
    }

    private void calculateAndDisplay() {
        double radius = Double.parseDouble(radiusEditText.getText().toString());

        if (toggleButton.isChecked()) {
            // Calculate Circumference
            double circumference = 2 * Math.PI * radius;
            resultTextView.setText("Circumference: " + circumference);
        } else {
            // Calculate Area
            double area = Math.PI * radius * radius;
            resultTextView.setText("Area: " + area);
        }
    }
}
