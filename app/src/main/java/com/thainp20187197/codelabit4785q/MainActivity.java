package com.thainp20187197.codelabit4785q;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextMSSV = findViewById(R.id.editTextMSSV);
        editTextBirthday = findViewById(R.id.editTextBirthday);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmail);
        checkBoxAgreement = findViewById(R.id.checkBoxAgreement);
    }

    EditText editTextName;
    EditText editTextMSSV;
    EditText editTextBirthday;
    EditText editTextPhone;
    EditText editTextEmail;
    CheckBox checkBoxAgreement;


    public void Submit(View view) {
        if (!checkBoxAgreement.isChecked())
        {
            Toast.makeText(this, "Chưa đồng ý điều khoản", Toast.LENGTH_SHORT).show();
            return;
        }

        String invalid = "Thiếu trường:";
        String fields = "";
        if (editTextName.getText().toString().isEmpty())
        {
            fields += " Họ tên;";
        }
        if (editTextMSSV.getText().toString().isEmpty())
        {
            fields += " MSSV;";
        }
        if (editTextBirthday.getText().toString().isEmpty())
        {
            fields += " Ngày sinh;";
        }
        if (editTextPhone.getText().toString().isEmpty())
        {
            fields += " Số điện thoại;";
        }
        if (editTextEmail.getText().toString().isEmpty())
        {
            fields += " Email;";
        }

        if ((invalid + fields).compareTo(invalid) == 0)
        {
            Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, invalid + fields, Toast.LENGTH_SHORT).show();
        }
    }
}