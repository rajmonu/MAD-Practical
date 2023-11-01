package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText, phoneEditText, addressEditText, emailEditText, countryEditText;
    private TextView savedDataTextView; // Add this TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        emailEditText = findViewById(R.id.emailEditText);
        countryEditText = findViewById(R.id.countryEditText);

        savedDataTextView = findViewById(R.id.savedDataTextView1); // Initialize the TextView

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
                loadUserData(); // Load and display the saved data
            }
        });

        loadUserData(); // Load and display the saved data when the app starts
    }

    private void saveUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameEditText.getText().toString());
        editor.putString("phone", phoneEditText.getText().toString());
        editor.putString("address", addressEditText.getText().toString());
        editor.putString("email", emailEditText.getText().toString());
        editor.putString("country", countryEditText.getText().toString());
        editor.apply();
    }

    private void loadUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String phone = sharedPreferences.getString("phone", "");
        String address = sharedPreferences.getString("address", "");
        String email = sharedPreferences.getString("email", "");
        String country = sharedPreferences.getString("country", "");

        // Display the loaded data in the TextView
        String savedData = "Name: " + name + "\nPhone: " + phone + "\nAddress: " + address + "\nEmail: " + email + "\nCountry: " + country;
        savedDataTextView.setText(savedData);
    }
}
