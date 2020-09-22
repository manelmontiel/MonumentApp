package com.example.appmonumentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Tutorial extends AppCompatActivity {

    private Button btnTutorialJuego;
    private Button btnTutorialMonumentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Tutoriales");

        final Intent intentTutorialJuego = new Intent(this, TutorialJuego.class);

        btnTutorialJuego = findViewById(R.id.tutorialJuego);

        btnTutorialJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTutorialJuego);
            }
        });

        final Intent intentTutorialMonumentos = new Intent(this, TutorialMonumentos.class);

        btnTutorialMonumentos = findViewById(R.id.tutorialMonumentos);

        btnTutorialMonumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTutorialMonumentos);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
