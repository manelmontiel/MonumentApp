package com.example.appmonumentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Puntuacion extends AppCompatActivity {

    private TextView aciertosContinentes;
    private TextView aciertosPais;
    private TextView aciertosCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);

        setTitle("Puntuaciones");

        aciertosContinentes = findViewById(R.id.aciertosCont);
        aciertosPais = findViewById(R.id.aciertosPais);
        aciertosCiudades = findViewById(R.id.aciertosCiud);

        aciertosContinentes.setText(String.valueOf(Niveles.aciertosContinentes) + " aciertos");
        aciertosPais.setText(String.valueOf(Niveles.aciertosPais) + " aciertos");
        aciertosCiudades.setText(String.valueOf(Niveles.aciertosCiudad) + " aciertos");

        /*aciertosContinentes.setText(String.valueOf(Niveles.aciertosContinentes) + " aciertos");
        aciertosPais.setText(String.valueOf(Niveles.aciertosPais) + " aciertos");
        aciertosCiudades.setText(String.valueOf(Niveles.aciertosCiudad) + " aciertos");*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
