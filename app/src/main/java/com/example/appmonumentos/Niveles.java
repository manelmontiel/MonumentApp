package com.example.appmonumentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Niveles extends AppCompatActivity {

    private Button btnNivelContinente;
    private Button btnNivelPais;
    private Button btnNivelCiudad;
    private ImageView medallaContinentes;
    private ImageView medallaPais;
    private ImageView medallaCiudad;
    private int nivel;
    public static int aciertosContinentes = 0;
    public static int aciertosPais = 0;
    public static int aciertosCiudad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

        setTitle("Niveles");

        btnNivelContinente = findViewById(R.id.buttonContinente);
        btnNivelPais = findViewById(R.id.buttonPais);
        btnNivelCiudad = findViewById(R.id.buttonCiudad);
        medallaContinentes = findViewById(R.id.imgMedallaCont);
        medallaPais = findViewById(R.id.imgMedallaPais);
        medallaCiudad = findViewById(R.id.imgMedallaCiud);

        if(aciertosContinentes < 15){
            Drawable buttonDrawable = btnNivelPais.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.parseColor("#a0a0a0"));
            btnNivelPais.setBackground(buttonDrawable);
            btnNivelPais.setText("Bloqueado");

        }
        else{
            Drawable buttonDrawable = btnNivelPais.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.parseColor("#FDE000"));
            btnNivelPais.setBackground(buttonDrawable);
            btnNivelPais.setText("Paises");
        }

        if(aciertosPais < 15){
            Drawable buttonDrawable = btnNivelCiudad.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.parseColor("#a0a0a0"));
            btnNivelCiudad.setBackground(buttonDrawable);
            btnNivelCiudad.setText("Bloqueado");
        }else{
            Drawable buttonDrawable = btnNivelCiudad.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.parseColor("#FF0000"));
            btnNivelCiudad.setBackground(buttonDrawable);
            btnNivelCiudad.setText("Ciudades");
        }

        if(aciertosContinentes>=15 && aciertosContinentes<25){
            medallaContinentes.setImageResource(getResources().getIdentifier("@drawable/medalla_bronce_transparente","drawable", getOpPackageName()));
        }else if(aciertosContinentes>=25 && aciertosContinentes<30){
            medallaContinentes.setImageResource(getResources().getIdentifier("@drawable/medalla_plata_transparente","drawable", getOpPackageName()));
        }else if(aciertosContinentes>= 30){
            medallaContinentes.setImageResource(getResources().getIdentifier("@drawable/medalla_oro_transparente","drawable", getOpPackageName()));
        }

        if(aciertosPais>=15 && aciertosPais<25){
            medallaPais.setImageResource(getResources().getIdentifier("@drawable/medalla_bronce_transparente","drawable", getOpPackageName()));
        }else if(aciertosPais>=25 && aciertosPais<30){
            medallaPais.setImageResource(getResources().getIdentifier("@drawable/medalla_plata_transparente","drawable", getOpPackageName()));
        }else if(aciertosPais>= 30){
            medallaPais.setImageResource(getResources().getIdentifier("@drawable/medalla_oro_transparente","drawable", getOpPackageName()));
        }

        if(aciertosCiudad>=15 && aciertosCiudad<25){
            medallaCiudad.setImageResource(getResources().getIdentifier("@drawable/medalla_bronce_transparente","drawable", getOpPackageName()));
        }else if(aciertosCiudad>=25 && aciertosCiudad<30){
            medallaCiudad.setImageResource(getResources().getIdentifier("@drawable/medalla_plata_transparente","drawable", getOpPackageName()));
        }else if(aciertosCiudad>= 30){
            medallaCiudad.setImageResource(getResources().getIdentifier("@drawable/medalla_oro_transparente","drawable", getOpPackageName()));
        }

        final Intent intentContinentes = new Intent(this, Juego.class);


        btnNivelContinente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentContinentes.putExtra("nivel", 1);
                startActivityForResult(intentContinentes, 11111);
            }
        });

        final Intent intentPais = new Intent(this, Juego.class);



        btnNivelPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aciertosContinentes < 15) {
                    Toast.makeText(getApplicationContext(), "No puedes entrar. Tendras que llegar a 15 aciertos en Continentes.", Toast.LENGTH_LONG).show();
                }else{
                    intentPais.putExtra("nivel", 2);
                    startActivityForResult(intentPais, 22222);
                }
            }
        });

        final Intent intentCiudad = new Intent(this, Juego.class);

        btnNivelCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aciertosPais < 15){
                    Toast.makeText(getApplicationContext(), "No puedes entrar. Tendras que llegar a 15 aciertos en Paises.", Toast.LENGTH_LONG).show();
                }else{
                    intentCiudad.putExtra("nivel", 3);
                    startActivityForResult(intentCiudad,33333);
                }

            }
        });
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

    @Override protected void onActivityResult (int requestCode,
        int resultCode, Intent data) {
            if (requestCode == 11111 && resultCode == RESULT_OK) {
                finish();
                startActivity(getIntent());
            }
            if (requestCode == 22222 && resultCode == RESULT_OK) {
                finish();
                startActivity(getIntent());
            }
            if (requestCode == 33333 && resultCode == RESULT_OK) {
                finish();
                startActivity(getIntent());
            }
        }
}
