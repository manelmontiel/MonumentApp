package com.example.appmonumentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Juego extends AppCompatActivity {

    private ArrayList<cPregunta> preguntasContinentes = new ArrayList<cPregunta>();
    private cPregunta resposta;
    private ArrayList<cPregunta> preguntasPais = new ArrayList<cPregunta>();
    private ArrayList<cPregunta> preguntasCiudad = new ArrayList<cPregunta>();
    public static int longitudPreguntasContinentes = 0;
    public static int longitudPreguntasPais = 0;
    public static int longitudPreguntasCiudad = 0;
    private int monRestantesContinente = 0;
    private int monRestantesPais = 0;
    private int monRestantesCiudad = 0;
    private int puntuacioJoc = 0;
    private int vidas = 3;
    static public int nivel = 0;
    public int index = 0;
    public String btn1Text;
    public String btn2Text;
    public String btn3Text;
    public String btn4Text;
    private TextView edt;
    private TextView edtVidas;
    private TextView nombreMonumento;
    private ImageView imagen;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        // deshabilita el titol
        getSupportActionBar().hide();

        // deshabilita la barra de notificacions
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();

        nivel = bundle.getInt("nivel");

        preguntasContinentes.add(new cPregunta("@drawable/statua_libertad", "Estatua de la Libertad", "America","America", "Africa", "Europa", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/torre_eiffel","Torre Eiffel", "Europa", "Europa", "America", "Asia", "Oceania", false));
        preguntasContinentes.add(new cPregunta("@drawable/mon_a_washington","Monumento a Washington", "America","America","Europa","Oceania", "Africa",false));
        preguntasContinentes.add(new cPregunta("@drawable/sagrada_familia", "Sagrada Familia", "Europa", "Europa", "Oceania", "America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/taj_mahal", "Taj Mahal", "Asia","Asia","Africa", "Europa", "Oceania", false));
        preguntasContinentes.add(new cPregunta("@drawable/esfinge", "Gran Esfinge de Guiza", "Africa","Africa","Asia","America","Europa",false));
        preguntasContinentes.add(new cPregunta("@drawable/coliseo", "Coliseo", "Europa","Europa", "America","Africa","Asia",false));
        preguntasContinentes.add(new cPregunta("@drawable/torre_pisa", "Torre de Pisa", "Europa","Europa", "America","Africa","Asia",false));
        preguntasContinentes.add(new cPregunta("@drawable/basilica_san_pedro", "Basilica de San Pedro", "Europa", "Europa", "America","Asia","Oceania",false));
        preguntasContinentes.add(new cPregunta("@drawable/monte_rushmore", "Monte Rushmore", "America","America", "Africa", "Europa", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/puerta_alcala", "Puerta de Alcala", "Europa", "Europa", "Oceania", "America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/cabezas_pascua", "Moais", "America","America", "Asia","Africa","Oceania", false));
        preguntasContinentes.add(new cPregunta("@drawable/guggenheim", "Museo Guggenheim", "Europa", "Europa", "Oceania", "America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/stonehenge", "Stonehenge", "Europa", "Europa", "Oceania", "America", "Africa", false));
        preguntasContinentes.add(new cPregunta("@drawable/big_ben", "Big Ben", "Europa", "Europa", "Oceania", "America", "Africa", false));
        preguntasContinentes.add(new cPregunta("@drawable/casa_batllo", "Casa Batllo", "Europa", "Europa", "Oceania", "America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/cristo_redentor", "Cristo Redentor", "America","America", "Oceania", "Europa", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/opera_sydney","Opera de Sydney", "Oceania","Oceania", "Europa", "America","Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/torre_tokio", "Torre de Tokio", "Asia","Asia","Europa","America","Africa",false));
        preguntasContinentes.add(new cPregunta("@drawable/partenon", "Partenon", "Europa", "Europa", "Africa", "America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/capilla_sixtina", "Capilla Sixtina", "Europa", "Europa", "Africa", "America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/piramides_guiza", "Piramides de Guiza", "Africa","Africa","Asia","America","Europa",false));
        preguntasContinentes.add(new cPregunta("@drawable/piramide_kukulkan","Piramide de Kukulkan", "America","America","Africa","Oceania", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/gran_muralla_china","Gran Muralla China", "Asia","Asia","Africa","Europa", "America", false));
        preguntasContinentes.add(new cPregunta("@drawable/machu_picchu","Machu Picchu", "America","America","Africa","Europa", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/catedral_san_basilio","Catedral de San Basilio", "Europa","Europa","Africa","America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/templo_ramses","Templo de Ramsés II", "Africa","Africa","Europa","America", "Oceania", false));
        preguntasContinentes.add(new cPregunta("@drawable/sky_tower","Sky Tower", "Oceania","Oceania","Europa","America", "Asia", false));
        preguntasContinentes.add(new cPregunta("@drawable/buda_tian_tan","Buda Tian Tan", "Asia","Asia","Oceania","Africa", "America", false));
        preguntasContinentes.add(new cPregunta("@drawable/obelisco","Obelisco", "America","America","Oceania","Europa", "America", false));

        preguntasPais.add(new cPregunta("@drawable/statua_libertad","Estatua de la Libertad", "USA","USA", "Argentina", "Canada", "Mexico",false));
        preguntasPais.add(new cPregunta("@drawable/torre_eiffel","Torre Eiffel", "Francia", "Francia", "España","Inglaterra", "Italia",false));
        preguntasPais.add(new cPregunta("@drawable/mon_a_washington","Monumento a Washington", "USA", "USA", "Argentina", "Chile","Canada",false));
        preguntasPais.add(new cPregunta("@drawable/sagrada_familia", "Sagrada Familia", "España", "España", "Italia", "Francia", "Inglaterra", false));
        preguntasPais.add(new cPregunta("@drawable/taj_mahal", "Taj Mahal", "India","India","China", "Turquia", "Tailandia", false));
        preguntasPais.add(new cPregunta("@drawable/esfinge", "Gran Esfinge de Guiza", "Egipto","Egipto","Marruecos","Argelia","Tunez",false));
        preguntasPais.add(new cPregunta("@drawable/coliseo","Coliseo", "Italia","Italia", "España", "Grecia", "Francia", false));
        preguntasPais.add(new cPregunta("@drawable/torre_pisa","Torre de Pisa", "Italia","Italia", "España", "Grecia", "Francia", false));
        preguntasPais.add(new cPregunta("@drawable/basilica_san_pedro", "Basilica de San Pedro", "El Vaticano", "El Vaticano", "Italia","España","Grecia",false));
        preguntasPais.add(new cPregunta("@drawable/monte_rushmore","Monte Rushmore", "USA","USA", "Argentina", "Canada", "Chile",false));
        preguntasPais.add(new cPregunta("@drawable/puerta_alcala", "Puerta de Alcala", "España", "España", "Francia", "Italia", "Portugal", false));
        preguntasPais.add(new cPregunta("@drawable/cabezas_pascua", "Moais", "Chile","Chile", "Ecuador","Brasil","Colombia", false));
        preguntasPais.add(new cPregunta("@drawable/guggenheim", "Museo Guggenheim", "España", "España", "Dinamarca", "Belgica", "Alemania", false));
        preguntasPais.add(new cPregunta("@drawable/stonehenge","Stonehenge", "Inglaterra", "Inglaterra", "Irlanda","Francia", "Escocia",false));
        preguntasPais.add(new cPregunta("@drawable/big_ben","Big Ben", "Inglaterra", "Inglaterra", "España","Francia", "Alemania",false));
        preguntasPais.add(new cPregunta("@drawable/casa_batllo", "Casa Batllo", "España", "España", "Italia", "Austria", "Belgica", false));
        preguntasPais.add(new cPregunta("@drawable/cristo_redentor", "Cristo Redentor", "Brasil","Brasil", "Colombia", "Peru", "Chile", false));
        preguntasPais.add(new cPregunta("@drawable/opera_sydney","Opera de Sydney", "Australia","Australia", "Nueva Zelanda", "Fiyi","Islas Marshall", false));
        preguntasPais.add(new cPregunta("@drawable/torre_tokio", "Torre de Tokio", "Japon","Japon","China","Singapur","Korea del Sur",false));
        preguntasPais.add(new cPregunta("@drawable/partenon", "Partenon", "Grecia", "Grecia", "Italia", "Malta", "Macedonia", false));
        preguntasPais.add(new cPregunta("@drawable/capilla_sixtina", "Capilla Sixtina", "El Vaticano", "El Vaticano", "Italia", "España", "Francia", false));
        preguntasPais.add(new cPregunta("@drawable/piramides_guiza", "Piramides de Guiza", "Egipto","Egipto","Marruecos","Argelia","Tunez",false));
        preguntasPais.add(new cPregunta("@drawable/piramide_kukulkan","Piramide de Kukulkan", "Mexico","Mexico","Guatemala","Nicaragua", "Costa Rica", false));
        preguntasPais.add(new cPregunta("@drawable/gran_muralla_china","Gran Muralla China", "China","China","Japon","India", "Mongolia", false));
        preguntasPais.add(new cPregunta("@drawable/machu_picchu","Machu Picchu", "Peru","Peru","Chile","Colombia", "Ecuador", false));
        preguntasPais.add(new cPregunta("@drawable/catedral_san_basilio","Catedral de San Basilio", "Rusia","Rusia","Ucrania","Letonia", "Polonia", false));
        preguntasPais.add(new cPregunta("@drawable/templo_ramses","Templo de Ramsés II", "Egipto","Egipto","Argelia","Tunez", "Libia", false));
        preguntasPais.add(new cPregunta("@drawable/sky_tower","Sky Tower", "Nueva Zelanda","Nueva Zelanda","Australia","Fiyi", "Islas Marshall", false));
        preguntasPais.add(new cPregunta("@drawable/buda_tian_tan","Buda Tian Tan", "China","China","Japon","Tailandia", "Bangladesh", false));
        preguntasPais.add(new cPregunta("@drawable/obelisco","Obelisco", "Argentina","Argentina","Chile","Brasil", "Uruguay", false));

        preguntasCiudad.add(new cPregunta("@drawable/statua_libertad","Estatua de la Libertad", "Nueva York", "Nueva York", "Miami", "Los Angeles", "Washington D.C.",false));
        preguntasCiudad.add(new cPregunta("@drawable/torre_eiffel","Torre Eiffel", "Paris", "Paris", "Lille", "Marsella", "Lyon",false));
        preguntasCiudad.add(new cPregunta("@drawable/mon_a_washington","Monumento a Washington", "Washington D.C.","Washington D.C.","Seattle","Las Vegas", "Chicago",false));
        preguntasCiudad.add(new cPregunta("@drawable/sagrada_familia", "Sagrada Familia", "Barcelona", "Barcelona", "Burgos", "Santiago de Compostela", "Leon", false));
        preguntasCiudad.add(new cPregunta("@drawable/taj_mahal", "Taj Mahal", "Agra","Agra","Mumbai", "Nueva Delhi", "Calcuta", false));
        preguntasCiudad.add(new cPregunta("@drawable/esfinge", "Gran Esfinge de Guiza", "Guiza","Guiza","El Cairo","Alejandria","Luxor",false));
        preguntasCiudad.add(new cPregunta("@drawable/coliseo","Coliseo", "Roma","Roma", "Venecia", "Pisa", "Florencia", false));
        preguntasCiudad.add(new cPregunta("@drawable/torre_pisa","Torre de Pisa", "Pisa","Pisa", "Venecia", "Sicilia", "Florencia", false));
        preguntasCiudad.add(new cPregunta("@drawable/basilica_san_pedro", "Basilica de San Pedro", "Ciudad del Vaticano", "Ciudad del Vaticano", "Roma","Florencia","Venecia",false));
        preguntasCiudad.add(new cPregunta("@drawable/monte_rushmore","Monte Rushmore", "Dakota del Sur", "Dakota del Sur", "Cleveland", "Portland", "Austin",false));
        preguntasCiudad.add(new cPregunta("@drawable/puerta_alcala", "Puerta de Alcala", "Madrid", "Madrid", "Barcelona", "Sevilla", "Valencia", false));
        preguntasCiudad.add(new cPregunta("@drawable/cabezas_pascua", "Moais", "Isla de Pascua","Isla de Pascua", "Santiago","Concepción","Valparaíso", false));
        preguntasCiudad.add(new cPregunta("@drawable/guggenheim", "Museo Guggenheim", "Bilbao", "Bilbao", "Madrid", "Valencia", "Barcelona", false));
        preguntasCiudad.add(new cPregunta("@drawable/stonehenge","Stonehenge", "Salisbury", "Salisbury", "Nottingham","Southampton", "York",false));
        preguntasCiudad.add(new cPregunta("@drawable/big_ben","Big Ben", "Londres", "Londres", "Liverpool","Manchester", "Bristol",false));
        preguntasCiudad.add(new cPregunta("@drawable/casa_batllo", "Casa Batllo", "Barcelona", "Barcelona", "Bilbao", "Mallorca", "Madrid", false));
        preguntasCiudad.add(new cPregunta("@drawable/cristo_redentor", "Cristo Redentor", "Rio de Janeiro","Rio de Janeiro", "Sao Paulo", "Fortaleza", "Porto Alegre", false));
        preguntasCiudad.add(new cPregunta("@drawable/opera_sydney","Opera de Sydney", "Sydney","Sydney", "Melbourne", "Canberra","Perth", false));
        preguntasCiudad.add(new cPregunta("@drawable/torre_tokio", "Torre de Tokio", "Tokio","Tokio","Osaka","Hiroshima","Kioto",false));
        preguntasCiudad.add(new cPregunta("@drawable/partenon", "Partenon", "Atenas", "Atenas", "Salonica", "Patras", "Heraclion", false));
        preguntasCiudad.add(new cPregunta("@drawable/capilla_sixtina", "Capilla Sixtina", "Ciudad del Vaticano", "Ciudad del Vaticano", "Roma","Florencia","Milan",false));
        preguntasCiudad.add(new cPregunta("@drawable/piramides_guiza", "Piramides de Guiza", "Guiza","Guiza","El Cairo","Alejandria","Luxor",false));
        preguntasCiudad.add(new cPregunta("@drawable/piramide_kukulkan","Piramide de Kukulkan", "Tinum","Tinum","Mazatlan","Guadalajara", "Tijuana", false));
        preguntasCiudad.add(new cPregunta("@drawable/gran_muralla_china","Gran Muralla China", "Todas son correctas","Todas son correctas","Pekín ","Gansu", "Tianjin", false));
        preguntasCiudad.add(new cPregunta("@drawable/machu_picchu","Machu Picchu", "Cusco","Cusco","Lima","Arequipa", "Chiclayo", false));
        preguntasCiudad.add(new cPregunta("@drawable/catedral_san_basilio","Catedral de San Basilio", "Moscu","Moscu","San Petersburgo","Kazan", "Sochi", false));
        preguntasCiudad.add(new cPregunta("@drawable/templo_ramses","Templo de Ramsés II", "Nubia","Nubia","Guiza","El Cairo", "Alejandria", false));
        preguntasCiudad.add(new cPregunta("@drawable/sky_tower","Sky Tower", "Auckland","Auckland","Wellington","Christchurch", "Queenstown", false));
        preguntasCiudad.add(new cPregunta("@drawable/buda_tian_tan","Buda Tian Tan", "Hong Kong","Hong Kong","Pekin","Shanghai", "Tianjin", false));
        preguntasCiudad.add(new cPregunta("@drawable/obelisco","Obelisco", "Buenos Aires","Buenos Aires","Rosario","Cordoba", "La Plata", false));

        monRestantesContinente = preguntasContinentes.size();
        monRestantesPais = preguntasPais.size();
        monRestantesCiudad = preguntasCiudad.size();

        longitudPreguntasContinentes = preguntasContinentes.size();
        longitudPreguntasPais = preguntasPais.size();
        longitudPreguntasCiudad = preguntasCiudad.size();

        setTitle("Donde está este monumento?");

        jocInici();

    }

    public void jocInici(){
        if(vidas == 0){
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
            Toast.makeText(getApplicationContext(), "Te has quedado sin vidas!!", Toast.LENGTH_LONG).show();
        }else {
            switch (nivel) {
                case 1:

                    if(monRestantesContinente == 0){
                        Toast.makeText(getApplicationContext(), "Felicidades!! Has acabado el nivel!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }else {
                        boolean sortida = true;
                        while(sortida == true){
                            index = (int) (Math.random() * preguntasContinentes.size() + 0);
                            if(preguntasContinentes.get(index).getMostrada() == false){
                                sortida = false;
                            }
                        }
                            //edt = (TextView) findViewById(R.id.rondaJoc);
                            //edt.setText("Ronda: " + rondaJoc);
                            preguntasContinentes.get(index).setMostrada(true);
                            monRestantesContinente--;

                            edt = (TextView) findViewById(R.id.puntuacioJoc);
                            edt.setText("Puntuació: " + puntuacioJoc);

                            edtVidas = (TextView) findViewById(R.id.vidasJoc);
                            edtVidas.setText("Vidas: " + vidas);

                            nombreMonumento = (TextView) findViewById(R.id.tvNombreMonumento);
                            nombreMonumento.setText(this.preguntasContinentes.get(index).getNombre());

                            imagen = (ImageView) findViewById(R.id.imageView);
                            imagen.setImageResource(getResources().getIdentifier(this.preguntasContinentes.get(index).getImagen(), "drawable", getOpPackageName()));

                            ArrayList<String> respuestasContinentes = new ArrayList<String>();
                            respuestasContinentes.add(this.preguntasContinentes.get(index).getOpcio1());
                            respuestasContinentes.add(this.preguntasContinentes.get(index).getOpcio2());
                            respuestasContinentes.add(this.preguntasContinentes.get(index).getOpcio3());
                            respuestasContinentes.add(this.preguntasContinentes.get(index).getOpcio4());

                            Collections.shuffle(respuestasContinentes);

                            //this.preguntasPais = preguntaMonumentos();
                            //Collections.shuffle(this.preguntasPais);

                            //edt = (TextView) findViewById(R.id.elementGame);
                            //edt.setText(this.resposta.getSimbol());

                            btn1 = (Button) findViewById(R.id.opcioA);
                            btn1.setText(respuestasContinentes.get(0));
                            btn1Text = btn1.getText().toString();
                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    comprovarContinentes(btn1Text, index);
                                }
                            });


                            btn2 = (Button) findViewById(R.id.opcioB);
                            btn2.setText(respuestasContinentes.get(1));
                            btn2Text = btn2.getText().toString();
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    comprovarContinentes(btn2Text, index);
                                }
                            });

                            btn3 = (Button) findViewById(R.id.opcioC);
                            btn3.setText(respuestasContinentes.get(2));
                            btn3Text = btn3.getText().toString();
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    comprovarContinentes(btn3Text, index);
                                }
                            });

                            btn4 = (Button) findViewById(R.id.opcioD);
                            btn4.setText(respuestasContinentes.get(3));
                            btn4Text = btn4.getText().toString();
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    comprovarContinentes(btn4Text, index);
                                }
                            });
                        }

                    break;
                case 2:

                    if(monRestantesPais == 0){
                        Toast.makeText(getApplicationContext(), "Felicidades!! Has acabado el nivel!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }else {
                        boolean sortida = true;
                        while (sortida == true) {
                            index = (int) (Math.random() * preguntasPais.size() + 0);
                            if (preguntasPais.get(index).getMostrada() == false) {
                                sortida = false;
                            }
                        }

                        preguntasPais.get(index).setMostrada(true);
                        monRestantesPais--;

                        //edt = (TextView) findViewById(R.id.rondaJoc);
                        //edt.setText("Ronda: " + rondaJoc);

                        edt = (TextView) findViewById(R.id.puntuacioJoc);
                        edt.setText("Puntuació: " + puntuacioJoc);

                        edtVidas = (TextView) findViewById(R.id.vidasJoc);
                        edtVidas.setText("Vidas: " + vidas);

                        nombreMonumento = (TextView) findViewById(R.id.tvNombreMonumento);
                        nombreMonumento.setText(this.preguntasPais.get(index).getNombre());

                        imagen = (ImageView) findViewById(R.id.imageView);
                        imagen.setImageResource(getResources().getIdentifier(this.preguntasContinentes.get(index).getImagen(), "drawable", getOpPackageName()));

                        ArrayList<String> respuestasPais = new ArrayList<String>();
                        respuestasPais.add(this.preguntasPais.get(index).getOpcio1());
                        respuestasPais.add(this.preguntasPais.get(index).getOpcio2());
                        respuestasPais.add(this.preguntasPais.get(index).getOpcio3());
                        respuestasPais.add(this.preguntasPais.get(index).getOpcio4());

                        Collections.shuffle(respuestasPais);
                        //this.preguntasPais = preguntaMonumentos();
                        //Collections.shuffle(this.preguntasPais);

                        //edt = (TextView) findViewById(R.id.elementGame);
                        //edt.setText(this.resposta.getSimbol());

                        btn1 = (Button) findViewById(R.id.opcioA);
                        btn1.setText(respuestasPais.get(0));
                        btn1Text = btn1.getText().toString();
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarPais(btn1Text, index);
                            }
                        });


                        btn2 = (Button) findViewById(R.id.opcioB);
                        btn2.setText(respuestasPais.get(1));
                        btn2Text = btn2.getText().toString();
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarPais(btn2Text, index);
                            }
                        });

                        btn3 = (Button) findViewById(R.id.opcioC);
                        btn3.setText(respuestasPais.get(2));
                        btn3Text = btn3.getText().toString();
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarPais(btn3Text, index);
                            }
                        });

                        btn4 = (Button) findViewById(R.id.opcioD);
                        btn4.setText(respuestasPais.get(3));
                        btn4Text = btn4.getText().toString();
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarPais(btn4Text, index);
                            }
                        });
                    }
                    break;
                case 3:

                    if(monRestantesCiudad == 0){
                        Toast.makeText(getApplicationContext(), "Felicidades!! Has acabado el nivel!!", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        boolean sortida = true;
                        while (sortida == true) {
                            index = (int) (Math.random() * preguntasCiudad.size() + 0);
                            if (preguntasCiudad.get(index).getMostrada() == false) {
                                sortida = false;
                            }
                        }
                        preguntasCiudad.get(index).setMostrada(true);
                        monRestantesCiudad--;
                        //edt = (TextView) findViewById(R.id.rondaJoc);
                        //edt.setText("Ronda: " + rondaJoc);

                        edt = (TextView) findViewById(R.id.puntuacioJoc);
                        edt.setText("Puntuació: " + puntuacioJoc);

                        edtVidas = (TextView) findViewById(R.id.vidasJoc);
                        edtVidas.setText("Vidas: " + vidas);

                        nombreMonumento = (TextView) findViewById(R.id.tvNombreMonumento);
                        nombreMonumento.setText(this.preguntasCiudad.get(index).getNombre());

                        imagen = (ImageView) findViewById(R.id.imageView);
                        imagen.setImageResource(getResources().getIdentifier(this.preguntasContinentes.get(index).getImagen(), "drawable", getOpPackageName()));

                        ArrayList<String> respuestasCiudad = new ArrayList<String>();
                        respuestasCiudad.add(this.preguntasCiudad.get(index).getOpcio1());
                        respuestasCiudad.add(this.preguntasCiudad.get(index).getOpcio2());
                        respuestasCiudad.add(this.preguntasCiudad.get(index).getOpcio3());
                        respuestasCiudad.add(this.preguntasCiudad.get(index).getOpcio4());

                        Collections.shuffle(respuestasCiudad);
                        //this.preguntasPais = preguntaMonumentos();
                        //Collections.shuffle(this.preguntasPais);

                        //edt = (TextView) findViewById(R.id.elementGame);
                        //edt.setText(this.resposta.getSimbol());

                        btn1 = (Button) findViewById(R.id.opcioA);
                        btn1.setText(respuestasCiudad.get(0));
                        btn1Text = btn1.getText().toString();
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarCiudad(btn1Text, index);
                            }
                        });


                        btn2 = (Button) findViewById(R.id.opcioB);
                        btn2.setText(respuestasCiudad.get(1));
                        btn2Text = btn2.getText().toString();
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarCiudad(btn2Text, index);
                            }
                        });

                        btn3 = (Button) findViewById(R.id.opcioC);
                        btn3.setText(respuestasCiudad.get(2));
                        btn3Text = btn3.getText().toString();
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarCiudad(btn3Text, index);
                            }
                        });

                        btn4 = (Button) findViewById(R.id.opcioD);
                        btn4.setText(respuestasCiudad.get(3));
                        btn4Text = btn4.getText().toString();
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comprovarCiudad(btn4Text, index);
                            }
                        });
                    }
                    break;
            }
        }
    }

    public void comprovarContinentes(String opcio, int index){
        if(opcio.equals(preguntasContinentes.get(index).getCorrecta())){
            Toast.makeText(getApplicationContext(), "Correcto!!", Toast.LENGTH_SHORT).show();
            puntuacioJoc++;
            if(puntuacioJoc > Niveles.aciertosContinentes){
                Niveles.aciertosContinentes = puntuacioJoc;
            }
            jocInici();
        }else{
            Toast.makeText(getApplicationContext(), "Incorrecto!! La respuesta es " + preguntasContinentes.get(index).getCorrecta(), Toast.LENGTH_SHORT).show();
            vidas--;
            jocInici();
        }
    }
    public void comprovarPais(String opcio, int index){
        if(opcio.equals(preguntasPais.get(index).getCorrecta())){
            Toast.makeText(getApplicationContext(), "Correcto!!", Toast.LENGTH_SHORT).show();
            puntuacioJoc++;
            if(puntuacioJoc > Niveles.aciertosPais){
                Niveles.aciertosPais = puntuacioJoc;
            }
            jocInici();
        }else{
            Toast.makeText(getApplicationContext(), "Incorrecto!! La respuesta es " + preguntasPais.get(index).getCorrecta(), Toast.LENGTH_SHORT).show();
            vidas--;
            jocInici();
        }
    }
    public void comprovarCiudad(String opcio, int index){
        if(opcio.equals(preguntasCiudad.get(index).getCorrecta())){
            Toast.makeText(getApplicationContext(), "Correcto!!", Toast.LENGTH_SHORT).show();
            puntuacioJoc++;
            if(puntuacioJoc > Niveles.aciertosCiudad){
                Niveles.aciertosCiudad = puntuacioJoc;
            }
            jocInici();
        }else{
            Toast.makeText(getApplicationContext(), "Incorrecto!! La respuesta es " + preguntasCiudad.get(index).getCorrecta(), Toast.LENGTH_SHORT).show();
            vidas--;
            jocInici();
        }
    }

}
