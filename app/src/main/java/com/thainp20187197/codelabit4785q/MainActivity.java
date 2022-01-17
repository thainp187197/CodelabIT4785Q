package com.thainp20187197.codelabit4785q;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    File currentFile;
    ListView fileListView;
    FileAdapter fileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            Uri uri = Uri.parse("package:" + BuildConfig.APPLICATION_ID);
            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, uri);
            startActivity(intent);
        }

        fileAdapter = new FileAdapter();
        fileListView = findViewById(R.id.fileListView);
        fileListView.setAdapter(fileAdapter);
        fileListView.setOnItemClickListener(
                (parent, view, position, id) -> {
                    if (position == 0) {
                        onBackPressed();
                        return;
                    }
                    File file = (File) parent.getItemAtPosition(position);
                    if (file.isDirectory()) {
                        ChangeDirectory(file);
                    } else {
                        if (file.getName().contains(".txt")) {
                            Intent intent = new Intent(MainActivity.this, TextFileActivity.class);
                            intent.putExtra("filePath", file.getAbsolutePath());
                            intent.putExtra("fileName", file.getName());
                            startActivity(intent);
                        }
                    }
                }
        );

        ChangeDirectory(null);
    }

    private void ChangeDirectory(File file) {
        if (file == null) file = Environment.getExternalStorageDirectory();
        Log.v("TAG", Integer.toString(file.listFiles().length));
        currentFile = file;
        fileAdapter.newList(Arrays.asList(Objects.requireNonNull(file.listFiles())));
    }

    @Override
    public void onBackPressed() {
        ChangeDirectory(currentFile.getParentFile());
    }
}