package com.example.spiner;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    private TextView selectedOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> campusAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.campus_options,
                android.R.layout.simple_spinner_item
        );
        campusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(campusAdapter);

        ArrayAdapter<CharSequence> emptyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        emptyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(emptyAdapter);
        spinner2.setVisibility(View.GONE);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    // RMD Technical Campus is selected
                    ArrayAdapter<CharSequence> technicalAdapter = ArrayAdapter.createFromResource(
                            MainActivity.this,
                            R.array.technical_courses,
                            android.R.layout.simple_spinner_item
                    );
                    technicalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(technicalAdapter);
                } else if (position == 1) {
                    // RMD Medical Campus is selected
                    ArrayAdapter<CharSequence> medicalAdapter = ArrayAdapter.createFromResource(
                            MainActivity.this,
                            R.array.medical_courses,
                            android.R.layout.simple_spinner_item
                    );
                    medicalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(medicalAdapter);
                }
                spinner2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                spinner2.setVisibility(View.GONE);
            }
        });
    }
}
