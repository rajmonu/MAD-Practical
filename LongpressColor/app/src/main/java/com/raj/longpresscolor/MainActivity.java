package com.raj.longpresscolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] items = {"MCA", "MBA", "ENG", "BAMS", "BHMS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
            getMenuInflater().inflate(R.menu.color_menu, menu);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            return false; // Return false to let the Android framework handle the context menu opening.
        });


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.color_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View view = info.targetView;

        if (item.getItemId() == R.id.red) {
            view.setBackgroundColor(Color.RED);
            return true;
        } else if (item.getItemId() == R.id.green) {
            view.setBackgroundColor(Color.GREEN);
            return true;
        } else if (item.getItemId() == R.id.blue) {
            view.setBackgroundColor(Color.BLUE);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }



}