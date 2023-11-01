package com.example.circumference2page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private EditText radiusEditText;
    private TextView resultTextView;
    private int selectedRequestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiusEditText = findViewById(R.id.radiusEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button circumferenceButton = findViewById(R.id.circumferenceButton);
        Button areaButton = findViewById(R.id.areaButton);

        circumferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRequestCode = 1;
                launchSecondActivity(selectedRequestCode);
            }
        });

        areaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRequestCode = 2;
                launchSecondActivity(selectedRequestCode);
            }
        });
    };

    private void launchSecondActivity(int requestCode) {
        String radiusText = radiusEditText.getText().toString();
        if (!radiusText.isEmpty()) {
            double radius = Double.parseDouble(radiusText);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("requestCode", requestCode);
            intent.putExtra("radius", radius);
            startActivityForResult(intent, requestCode);
        } else {
            Toast.makeText(this, "Please enter a valid radius.", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle the result from SecondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == selectedRequestCode && resultCode == RESULT_OK) {
            double result = data.getDoubleExtra("result", 0.0);
            displayResult(result);
        }
    }

    private void displayResult(double result) {
        resultTextView.setText("Result: " + result);
    }
}
