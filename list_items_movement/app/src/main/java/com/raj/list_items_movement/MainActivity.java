package com.raj.list_items_movement;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView1, listView2;
    private EditText editText;
    private Button addButton1, addButton2, transferRightButton, transferLeftButton, transferAllRightButton, transferAllLeftButton;

    private ArrayList<String> list1Items, list2Items;
    private ArrayAdapter<String> adapter1, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        listView1 = findViewById(R.id.listView1);
        listView2 = findViewById(R.id.listView2);
        editText = findViewById(R.id.editText);
        addButton1 = findViewById(R.id.addButton1);
        addButton2 = findViewById(R.id.addButton2);
        transferRightButton = findViewById(R.id.transferRightButton);
        transferLeftButton = findViewById(R.id.transferLeftButton);
        transferAllRightButton = findViewById(R.id.transferAllRightButton);
        transferAllLeftButton = findViewById(R.id.transferAllLeftButton);

        // Initialize lists and adapters
        list1Items = new ArrayList<>();
        list2Items = new ArrayList<>();
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list1Items);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list2Items);

        // Set adapters for ListViews
        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);

        // Button click listeners
        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString();
                if (!item.isEmpty()) {
                    list1Items.add(item);
                    adapter1.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString();
                if (!item.isEmpty()) {
                    list2Items.add(item);
                    adapter2.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        transferRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferItem(listView1, list1Items, adapter1, list2Items, adapter2);
            }
        });

        transferLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferItem(listView2, list2Items, adapter2, list1Items, adapter1);
            }
        });

        transferAllRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferAllItems(listView1, list1Items, adapter1, list2Items, adapter2);
            }
        });

        transferAllLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferAllItems(listView2, list2Items, adapter2, list1Items, adapter1);
            }
        });
    }

    private void transferItem(ListView sourceListView, ArrayList<String> sourceList, ArrayAdapter<String> sourceAdapter,
                              ArrayList<String> destinationList, ArrayAdapter<String> destinationAdapter) {
        int position = sourceListView.getCheckedItemPosition();
        if (position != ListView.INVALID_POSITION) {
            String item = sourceList.get(position);
            sourceList.remove(position);
            sourceAdapter.notifyDataSetChanged();
            destinationList.add(item);
            destinationAdapter.notifyDataSetChanged();
        }
    }

    private void transferAllItems(ListView sourceListView, ArrayList<String> sourceList, ArrayAdapter<String> sourceAdapter,
                                  ArrayList<String> destinationList, ArrayAdapter<String> destinationAdapter) {
        destinationList.addAll(sourceList);
        sourceList.clear();
        sourceAdapter.notifyDataSetChanged();
        destinationAdapter.notifyDataSetChanged();
    }
}
