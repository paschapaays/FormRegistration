package com.example.formregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNim, etName, etEmail, etPhone, etJurusan;
    private Spinner spinnerFakultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNim = findViewById(R.id.et_nim);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etJurusan = findViewById(R.id.et_jurusan);
        spinnerFakultas = findViewById(R.id.spinner_fakultas);

        Button btnRegister = findViewById(R.id.btn_register);
        Button btnReset = findViewById(R.id.btn_reset);

        // Spinner data
        String[] fakultasList = {"FTI", "FE", "FIKOM", "FK"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fakultasList);
        spinnerFakultas.setAdapter(adapter);

        btnRegister.setOnClickListener(v -> {
            String nim = etNim.getText().toString().trim();
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String fakultas = spinnerFakultas.getSelectedItem().toString();
            String jurusan = etJurusan.getText().toString().trim();

            // Validasi input
            if (nim.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty() || jurusan.isEmpty()) {
                Toast.makeText(MainActivity.this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cek format email sederhana
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(MainActivity.this, "Format email tidak valid!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kirim data ke SummaryActivity
            Intent intent = new Intent(MainActivity.this, SummeryActivity.class);
            intent.putExtra("nim", nim);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("fakultas", fakultas);
            intent.putExtra("jurusan", jurusan);
            startActivity(intent);
        });

        btnReset.setOnClickListener(v -> {
            etNim.setText("");
            etName.setText("");
            etEmail.setText("");
            etPhone.setText("");
            etJurusan.setText("");
            spinnerFakultas.setSelection(0);
        });
    }
}