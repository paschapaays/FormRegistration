package com.example.formregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Menghubungkan dengan TextView dari layout
        TextView tvNim = findViewById(R.id.tv_nim);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvPhone = findViewById(R.id.tv_phone);
        TextView tvJurusan = findViewById(R.id.tv_jurusan);

        // Mendapatkan data dari Intent
        Intent intent = getIntent();
        String nim = intent.getStringExtra("nim");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String fakultas = intent.getStringExtra("fakultas");
        String jurusan = intent.getStringExtra("jurusan");

        // Menampilkan data ke TextView
        tvNim.setText(nim != null ? nim : "N/A");
        tvName.setText(name != null ? name : "N/A");
        tvEmail.setText(email != null ? email : "N/A");
        tvPhone.setText(phone != null ? phone : "N/A");
        tvJurusan.setText(jurusan != null ? jurusan : "N/A");
    }
}
