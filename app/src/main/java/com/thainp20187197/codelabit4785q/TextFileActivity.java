package com.thainp20187197.codelabit4785q;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_file);

        Bundle bundle = getIntent().getExtras();
        String filePath = bundle.getString("filePath");
        String fileName = bundle.getString("fileName");
        String content = "";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content += line + "\n";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            content = "File not found";
        } catch (IOException e) {
            e.printStackTrace();
            content = "File can't be read";
        }

        ((TextView) findViewById(R.id.textFileContentTextView)).setText(content);
        ((TextView) findViewById(R.id.textFileNameTextView)).setText(fileName);
    }
}
