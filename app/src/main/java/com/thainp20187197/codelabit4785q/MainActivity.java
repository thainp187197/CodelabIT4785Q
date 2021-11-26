package com.thainp20187197.codelabit4785q;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list_view);

        items = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            items.add(new ItemModel("Email " + (i + 1), "This is description."));

        ItemAdapter adapter = new ItemAdapter(items);
        listView.setAdapter(adapter);
    }
}