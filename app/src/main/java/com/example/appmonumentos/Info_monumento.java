package com.example.appmonumentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Info_monumento extends AppCompatActivity {
    private TextView textViewNombre;
    private TextView textViewContinente;
    private TextView textViewPais;
    private TextView textViewCiudad;
    private TextView textViewInformacion;
    private ImageView imgImagen;
    private Button btnWiki;
    private Button btnMaps;
    private String wikiImportada;
    private String ubiImportada;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_monumento);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("");

        Bundle bundle = getIntent().getExtras();
        wikiImportada = bundle.getString("url");

        Bundle bundle1 = getIntent().getExtras();
        final String nombreImportada = bundle1.getString("nombre");

        Bundle bundle2 = getIntent().getExtras();
        final String imagenImportada = bundle2.getString("imagen");

        Bundle bundle3 = getIntent().getExtras();
        final String continenteImportada = bundle3.getString("continente");

        Bundle bundle4 = getIntent().getExtras();
        final String paisImportada = bundle4.getString("pais");

        Bundle bundle5 = getIntent().getExtras();
        final String ciudadImportada = bundle5.getString("ciudad");

        Bundle bundle6 = getIntent().getExtras();
        final String infoImportada = bundle6.getString("informacion");

        Bundle bundle7 = getIntent().getExtras();
        ubiImportada = bundle7.getString("ubicacion");

        textViewNombre = (TextView)findViewById(R.id.tvInfoNombre);
        textViewNombre.setText(nombreImportada);

        imgImagen = (ImageView)findViewById(R.id.imgInfoImagen);
        imgImagen.setImageResource(getResources().getIdentifier(imagenImportada, "drawable", getOpPackageName()));

        textViewContinente = (TextView)findViewById(R.id.tvInfoContinente);
        textViewContinente.setText("Continente: \n" + continenteImportada);

        textViewPais = (TextView)findViewById(R.id.tvInfoPais);
        textViewPais.setText("Pais: \n" + paisImportada);

        textViewCiudad = (TextView)findViewById(R.id.tvInfoCiudad);
        textViewCiudad.setText("Ciudad: \n" + ciudadImportada);

        textViewInformacion = (TextView)findViewById(R.id.tvInfoInformacion);
        textViewInformacion.setText(infoImportada);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_monumento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.btnMenuWiki:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(wikiImportada));
                startActivity(intent);
                return true;
            case R.id.btnMenuMaps:
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ubiImportada));
                startActivity(mapIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
