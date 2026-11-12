package com.example.domekwgorach;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int liczbaPolubien = 0;
    private TextView tekstPolubien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this, SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT));
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tekstPolubien = findViewById(R.id.liczbaPolubien);
        Button przyciskPolub = findViewById(R.id.przyciskPolub);
        Button przyciskUsun = findViewById(R.id.przyciskUsun);
        Button przyciskZapisz = findViewById(R.id.przyciskZapisz);

        przyciskPolub.setOnClickListener(v -> polub());
        przyciskUsun.setOnClickListener(v -> usunPolubienie());
        przyciskZapisz.setOnClickListener(v -> Toast.makeText(this,
                getString(R.string.zapisano, liczbaPolubien), Toast.LENGTH_SHORT).show());

        pokazPolubienia();
    }

    private void polub() {
        liczbaPolubien++;
        pokazPolubienia();
    }

    private void usunPolubienie() {
        if (liczbaPolubien > 0) {
            liczbaPolubien--;
        }
        pokazPolubienia();
    }

    private void pokazPolubienia() {
        tekstPolubien.setText(getString(R.string.polubienia, liczbaPolubien));
    }
}
