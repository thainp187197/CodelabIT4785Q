package com.thainp20187197.codelabit4785q;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    List<File> files;
    ListView fileListView;
    File currentFile;
    FileAdapter fileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        files = new ArrayList<>();
        fileAdapter = new FileAdapter(files);
        fileListView = findViewById(R.id.fileListView);
        fileListView.setAdapter(fileAdapter);
        ChangeDirectory(null);
    }

    private void ChangeDirectory(File file) {
        if (file == null) file = Environment.getExternalStorageDirectory();
        currentFile = file;
        files = Arrays.asList(Objects.requireNonNull(file.listFiles()));
        fileAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        ChangeDirectory(currentFile.getParentFile());
    }
}