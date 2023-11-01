package com.example.popupmenu;//package com.example.popupmenu;
import com.example.popupmenu.R;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button colorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorButton = findViewById(R.id.colorButton);

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.colour_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.menu_red) {
                            colorButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                            return true;
                        } else if (itemId == R.id.menu_green) {
                            colorButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                            return true;
                        } else if (itemId == R.id.menu_blue) {
                            colorButton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                            return true;
                        } else {
                            return false;
                        }
                    }

                });

                popupMenu.show();
            }
        });
    }
}
