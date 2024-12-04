package com.example.formregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummeryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summery); // Pastikan file XML sesuai

        // Menghubungkan TextView dengan id yang ada di layout XML
        TextView tvFakultas = findViewById(R.id.tv_fakultas);
        TextView tvNim = findViewById(R.id.tv_nim);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvPhone = findViewById(R.id.tv_phone);
        TextView tvJurusan = findViewById(R.id.tv_jurusan);

        // Mendapatkan data dari Intent
        Intent intent = getIntent();
        String fakultas = intent.getStringExtra("fakultas");
        String nim = intent.getStringExtra("nim");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String jurusan = intent.getStringExtra("jurusan");

        // Menampilkan data ke dalam TextView
        if (fakultas != null) tvFakultas.setText(fakultas);
        if (nim != null) tvNim.setText(nim);
        if (name != null) tvName.setText(name);
        if (email != null) tvEmail.setText(email);
        if (phone != null) tvPhone.setText(phone);
        if (jurusan != null) tvJurusan.setText(jurusan);
    }
}