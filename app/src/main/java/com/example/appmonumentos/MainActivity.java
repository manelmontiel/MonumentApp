package com.example.appmonumentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnListViewMonumentos;
    private Button buttonJuego;                 //nose porque si desbloqueo el 2n nivel los botones se ponen grises y si desbloqueo el 3r se ponen rojos
    private Button buttonPuntuacion;
    private Button buttonTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // deshabilita el titol
        getSupportActionBar().hide();

        // deshabilita la barra de notificacions
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Intent intentMonumentos = new Intent(this, ListView.class);

        btnListViewMonumentos = findViewById(R.id.btnMonumentos);
        Drawable buttonDrawable1 = btnListViewMonumentos.getBackground();
        buttonDrawable1 = DrawableCompat.wrap(buttonDrawable1);
        DrawableCompat.setTint(buttonDrawable1, Color.parseColor("#80FFFFFF"));
        btnListViewMonumentos.setBackground(buttonDrawable1);

        btnListViewMonumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMonumentos);
            }
        });

        final Intent intentJuego = new Intent(this, Niveles.class);

        buttonJuego = findViewById(R.id.btnJuego);

        Drawable buttonDrawable2 = buttonJuego.getBackground();
        buttonDrawable2 = DrawableCompat.wrap(buttonDrawable2);
        DrawableCompat.setTint(buttonDrawable2, Color.parseColor("#80FFFFFF"));
        buttonJuego.setBackground(buttonDrawable2);

        buttonJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentJuego);
            }
        });

        final Intent intentPuntuacion = new Intent(this, Puntuacion.class);

        buttonPuntuacion = findViewById(R.id.btnPuntuacion);

        Drawable buttonDrawable3 = buttonPuntuacion.getBackground();
        buttonDrawable3 = DrawableCompat.wrap(buttonDrawable3);
        DrawableCompat.setTint(buttonDrawable3, Color.parseColor("#80FFFFFF"));
        buttonPuntuacion.setBackground(buttonDrawable3);

        buttonPuntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPuntuacion);
            }
        });

        final Intent intentTutorial = new Intent(this, Tutorial.class);

        buttonTutorial = findViewById(R.id.btnTutorial);

        Drawable buttonDrawable4 = buttonTutorial.getBackground();
        buttonDrawable4 = DrawableCompat.wrap(buttonDrawable4);
        DrawableCompat.setTint(buttonDrawable4, Color.parseColor("#80FFFFFF"));
        buttonTutorial.setBackground(buttonDrawable4);

        buttonTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTutorial);
            }
        });

    }
}
