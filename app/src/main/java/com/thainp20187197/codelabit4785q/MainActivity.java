package com.thainp20187197.codelabit4785q;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button button_zero;
    private Button button_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        button_zero = findViewById(R.id.button_zero);
        button_count = findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
        {
            mShowCount.setText(Integer.toString(mCount));
            button_zero.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
            if (mCount % 2 == 0)
            {
                button_count.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryVariant));
            }
            else {
                button_count.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            }
        }
    }

    public void countZero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            button_zero.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
        }
    }
}