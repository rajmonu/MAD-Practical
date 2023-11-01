package com.example.timedate;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check the action that started this activity
        String action = getIntent().getAction();

        if ("SHOW_TIME".equals(action)) {
            // Display time
            setContentView(R.layout.activity_time);
            displayTime();
        } else if ("SHOW_DATE".equals(action)) {
            // Display date
            setContentView(R.layout.activity_date);
            displayDate();
        }
    }

    private void displayTime() {
        // Get the current time
        Date currentTime = new Date();

        // Format the time
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(currentTime);

        // Display the time in the TextView
        TextView timeTextView = findViewById(R.id.timeTextView);
        timeTextView.setText("Current Time: " + formattedTime);
    }

    private void displayDate() {
        // Get the current date
        Date currentDate = new Date();

        // Format the date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(currentDate);

        // Display the date in the TextView
        TextView dateTextView = findViewById(R.id.dateTextView);
        dateTextView.setText("Current Date: " + formattedDate);
    }
}

