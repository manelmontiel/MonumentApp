package com.example.appmonumentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {

    public static ArrayList<cMonumento> monumentos = new ArrayList<cMonumento>();
    public static int aciertosMaxNum;
    private ArrayList<cMonumento> monumentosFiltrat = new ArrayList<cMonumento>();

    private ArrayAdapter<String> adaptador;
    private android.widget.ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("");

        monumentos.clear();

        monumentos.add(new cMonumento("@drawable/statua_libertad", "Estatua de la Libertad", "America", "USA", "Nueva York", "https://es.wikipedia.org/wiki/Estatua_de_la_Libertad", "https://www.google.com/maps/place/Estatua+de+la+Libertad/@40.6892494,-74.0466891,17z/data=!3m1!4b1!4m5!3m4!1s0x89c25090129c363d:0x40c6a5770d25022b!8m2!3d40.6892494!4d-74.0445004", "La libertad iluminando el mundo, conocida como la Estatua de la Libertad, es uno de los monumentos más famosos de Nueva York, de los Estados Unidos y de todo el mundo. Se encuentra en la isla de la Libertad al sur de la isla de Manhattan, junto a la desembocadura del río Hudson y cerca de la isla Ellis."));
        monumentos.add(new cMonumento("@drawable/torre_eiffel", "Torre Eiffel", "Europa", "Francia", "Paris", "https://es.wikipedia.org/wiki/Torre_Eiffel", "https://www.google.com/maps/place/Torre+Eiffel/@48.8583701,2.2922926,17z/data=!3m1!4b1!4m5!3m4!1s0x47e66e2964e34e2d:0x8ddca9ee380ef7e0!8m2!3d48.8583701!4d2.2944813","La torre Eiffel, inicialmente llamada la tour de 300 mètres, es una estructura de hierro pudelado construida para la Exposición Universal de 1889 en París. Situada en el extremo del Campo de Marte a la orilla del río Sena, este monumento parisino, símbolo de Francia y de su capital, es la estructura más alta de la ciudad y el monumento que cobra entrada más visitado del mundo, con 7,1 millones de turistas cada año. Con una altura de 300 metros, prolongada más tarde con una antena hasta los 324 metros, la torre Eiffel fue la estructura más elevada del mundo durante 41 años."));
        monumentos.add(new cMonumento("@drawable/mon_a_washington", "Monumento a Washington", "America", "USA", "Washington D.C.", "https://es.wikipedia.org/wiki/Monumento_a_Washington", "https://www.google.com/maps?safe=strict&sxsrf=ACYBGNTy8H62ZnyOfhlSEn49y9ZbJhf6Rw:1576147696035&q=monumento+a+washington&um=1&ie=UTF-8&sa=X&ved=2ahUKEwiR6L7s96_mAhWKDmMBHc9_CcQQ_AUoAXoECBQQAw","El Monumento a Washington normalmente hace referencia al gran obelisco blanco localizado en el extremo al oeste del National Mall de Washington D. C. Es un monumento conmemorativo al primer presidente de los Estados Unidos y líder del revolucionario Ejército Continental, George Washington, que ganó la independencia del país luchando frente a los británicos en la Guerra de la Independencia. En 1884, el monumento se convirtió en la estructura más alta del mundo, hasta que se construyó la Torre Eiffel en 1889."));
        monumentos.add(new cMonumento("@drawable/sagrada_familia", "Sagrada Familia", "Europa", "España", "Barcelona", "https://es.wikipedia.org/wiki/Templo_Expiatorio_de_la_Sagrada_Familia", "https://www.google.com/maps/place/Bas%C3%ADlica+de+la+Sagrada+Fam%C3%ADlia/@41.4036299,2.1721671,17z/data=!3m1!4b1!4m5!3m4!1s0x12a4a2dcd83dfb93:0x9bd8aac21bc3c950!8m2!3d41.4036299!4d2.1743558","El Templo Expiatorio de la Sagrada Familia, conocido simplemente como la Sagrada Familia, es una basílica católica de Barcelona, diseñada por el arquitecto Antoni Gaudí. Iniciada en 1882, todavía está en construcción. Es la obra maestra de Gaudí, y el máximo exponente de la arquitectura modernista catalana."));
        monumentos.add(new cMonumento("@drawable/taj_mahal", "Taj Mahal", "Asia", "India", "Agra", "https://es.wikipedia.org/wiki/Taj_Mahal", "https://www.google.com/maps/place/Taj+Mahal/@27.1751448,78.0399535,17z/data=!3m1!4b1!4m5!3m4!1s0x39747121d702ff6d:0xdd2ae4803f767dde!8m2!3d27.1751448!4d78.0421422","El Taj Mahal es un monumento funerario construido entre 1631 y 1654 en la ciudad de Agra, estado de Uttar Pradesh (India), a orillas del río Yamuna, por el emperador musulmán Shah Jahan de la dinastía mogol. El imponente conjunto de edificios se erigió en honor de su esposa favorita, Arjumand Banu Begum, que murió en el parto de su decimocuarto hijo. Se estima que su construcción necesitó el esfuerzo de unos 20 000 obreros bajo dirección de un conjunto de arquitectos liderados por el arquitecto de la corte, Ustad Ahmad Lahori."));
        monumentos.add(new cMonumento("@drawable/esfinge", "Gran Esfinge de Guiza", "Africa", "Egipto", "Guiza", "https://es.wikipedia.org/wiki/Gran_Esfinge_de_Guiza", "https://www.google.com/maps/place/La+Esfinge/@29.9752687,31.1353787,17z/data=!3m1!4b1!4m5!3m4!1s0x14584f62a3aea979:0xc9d3f0a64066bda9!8m2!3d29.9752687!4d31.1375674","La Gran Esfinge de Guiza es una monumental escultura que se encuentra en la ribera occidental del río Nilo, en la ciudad de Guiza, unos veinte kilómetros al suroeste del centro de El Cairo. Los egiptólogos estiman que fue esculpida c. siglo XXVI a. C., formando parte del complejo funerario del rey, durante la dinastía IV de Egipto."));
        monumentos.add(new cMonumento("@drawable/coliseo", "Coliseo", "Europa", "Italia", "Roma", "https://es.wikipedia.org/wiki/Coliseo", "https://www.google.com/maps/place/Coliseo+de+Roma/@39.5227578,-5.0543247,5z/data=!4m8!1m2!2m1!1scoliseo!3m4!1s0x132f61b6532013ad:0x28f1c82e908503c4!8m2!3d41.8902102!4d12.4922309","El Coliseo o Anfiteatro Flavio es un anfiteatro de la época del Imperio romano, construido en el siglo I y ubicado en el centro de la ciudad de Roma. Su denominación original, Anfiteatro Flavio, hace referencia a la dinastía Flavia de emperadores que lo construyó; su nombre posterior, Coliseo, y por el que es más conocido en la actualidad, se debe a una gran estatua que había cerca, el Coloso de Nerón, que no ha llegado hasta nosotros. Por su conservación e historia, el Coliseo es uno de los monumentos más famosos de la Antigüedad clásica. Fue declarado Patrimonio de la Humanidad en 1980 por la Unesco y una de Las Nuevas Siete Maravillas del Mundo Moderno el 7 de julio de 2007."));
        monumentos.add(new cMonumento("@drawable/torre_pisa", "Torre de Pisa", "Europa", "Italia", "Pisa", "https://es.wikipedia.org/wiki/Torre_de_Pisa", "https://www.google.com/maps/place/Torre+de+Pisa/@43.722952,10.3944083,17z/data=!3m1!4b1!4m5!3m4!1s0x12d591a6c44e88cd:0x32eca9b1d554fc03!8m2!3d43.722952!4d10.396597","La torre de Pisa o torre inclinada de Pisa es la torre campanario de la catedral de Pisa, situada en la plaza del Duomo de Pisa, en la ciudad del mismo nombre, municipio de la región italiana de la Toscana y capital de la provincia homónima de Italia."));
        monumentos.add(new cMonumento("@drawable/basilica_san_pedro", "Basilica de San Pedro", "Europa", "El Vaticano", "Ciudad del Vaticano", "https://es.wikipedia.org/wiki/Bas%C3%ADlica_de_San_Pedro", "https://www.google.com/maps/place/Bas%C3%ADlica+de+San+Pedro/@41.9021667,12.451748,17z/data=!3m1!4b1!4m5!3m4!1s0x132f6061b7149b59:0x724bf077cd875283!8m2!3d41.9021667!4d12.4539367","La basílica papal de San Pedro, conocida comúnmente como basílica de San Pedro, es un templo católico situado en la Ciudad del Vaticano. La basílica cuenta con el mayor espacio interior de una iglesia cristiana en el mundo, presenta 193 m de longitud, 44,5 m de altura, y abarca una superficie de 2,3 hectáreas."));
        monumentos.add(new cMonumento("@drawable/monte_rushmore", "Monte Rushmore", "America", "USA", "Dakota del Sur", "https://es.wikipedia.org/wiki/Monte_Rushmore", "https://www.google.com/maps/place/Monte+Rushmore/@43.8791025,-103.4612554,17z/data=!3m1!4b1!4m5!3m4!1s0x877d35d8b53ed6df:0xdaf53dbe055cc641!8m2!3d43.8791025!4d-103.4590667","El Monumento Nacional Monte Rushmore es un monumental conjunto escultórico tallado entre 1927 y 1941 en una montaña de granito situada en Keystone, Dakota del Sur (Estados Unidos) en el que figuran los rostros de 18 metros de altura de los presidentes estadounidenses George Washington, Thomas Jefferson, Theodore Roosevelt y Abraham Lincoln. Fueron esculpidos por el escultor danés-estadounidense Gutzon Borglum y su hijo, Lincoln Borglum. Este monumento conmemora el nacimiento, el crecimiento, la conservación y el desarrollo de la nación estadounidense. El monumento nacional Monte Rushmore tiene 5,17 km² de extensión."));
        monumentos.add(new cMonumento("@drawable/puerta_alcala", "Puerta de Alcala", "Europa", "España", "Madrid", "https://es.wikipedia.org/wiki/Puerta_de_Alcal%C3%A1", "https://www.google.com/maps/place/Puerta+de+Alcal%C3%A1/@40.419992,-3.6909257,17z/data=!3m1!4b1!4m5!3m4!1s0xd42289a4a865227:0x98278b3a144a86f1!8m2!3d40.419992!4d-3.688737","La Puerta de Alcalá es una de las cinco antiguas puertas reales que daban acceso a la ciudad de Madrid (España). Se encuentra situada en el centro de la rotonda de la Plaza de la Independencia. La puerta daba acceso a aquellos viajeros que entraban antiguamente en la población desde Francia o Aragón. En la actualidad es una puerta monumental que se encuentra ubicada junto a la Fuente de Cibeles y el Parque del Retiro. Fue construida por mandato de Carlos III en sustitución de otra puerta anterior que existía ya desde el siglo XVI."));
        monumentos.add(new cMonumento("@drawable/cabezas_pascua", "Moais", "America", "Chile", "Isla de Pascua", "https://es.wikipedia.org/wiki/Mo%C3%A1i", "https://www.google.com/maps/place/%D0%9C%D0%BE%D0%B0%D1%97/@-27.1439625,-109.3326878,17z/data=!3m1!4b1!4m5!3m4!1s0x9947f1b353dbf5b3:0x7d0c6060d9c62ef6!8m2!3d-27.1439625!4d-109.3304991","Un moái es una estatua monolítica ubicada en la Isla de Pascua, perteneciente a la región de Valparaíso en Chile. Los moáis son el principal atractivo turístico de dicha isla."));
        monumentos.add(new cMonumento("@drawable/guggenheim", "Museo Guggenheim", "Europa", "España", "Bilbao", "https://es.wikipedia.org/wiki/Museo_Guggenheim_Bilbao", "https://www.google.com/maps/place/Museo+Guggenheim+Bilbao/@43.2686712,-2.9362005,17z/data=!3m1!4b1!4m5!3m4!1s0xd4e4fdede6031b5:0x508893b7cdaf6dad!8m2!3d43.2686712!4d-2.9340118","El Museo Guggenheim Bilbao es un museo de arte contemporáneo diseñado por el arquitecto canadiense Frank O. Gehry y localizado en la villa de Bilbao, España. Es uno de los museos pertenecientes a la Fundación Solomon R. Guggenheim. Fue inaugurado el 18 de octubre de 1997 por el rey Juan Carlos I de España."));
        monumentos.add(new cMonumento("@drawable/stonehenge", "Stonehenge", "Europa", "Inglaterra", "Salisbury", "https://es.wikipedia.org/wiki/Stonehenge", "https://www.google.com/maps/search/Stonehenge/@51.1324508,-1.8901326,12z/data=!3m1!4b1","Stonehenge es un monumento megalítico tipo crómlech, además de otros elementos como hoyos, fosos, montículos, etc. construido entre el final del Neolítico y principios de la Edad del Bronce, situado cerca de Amesbury, en el condado de Wiltshire, Inglaterra, a unos quince kilómetros al norte de Salisbury."));
        monumentos.add(new cMonumento("@drawable/big_ben", "Big Ben", "Europa", "Inglaterra", "Londres", "https://es.wikipedia.org/wiki/Big_Ben", "https://www.google.com/maps/place/Big+Ben/@46.0709786,-3.973354,5z/data=!4m8!1m2!2m1!1sBig+Ben!3m4!1s0x0:0xb78f2474b9a45aa9!8m2!3d51.5001944!4d-0.1235962","Big Ben es el nombre con el que se conoce a la gran campana del reloj situado en el lado noroeste del Palacio de Westminster, la sede del Parlamento del Reino Unido, en Londres, y popularmente por extensión se utiliza también para nombrar al reloj de la torre. La torre alberga el reloj de cuatro caras más grande del mundo, y es la decimocuarta torre de reloj más alta del mundo. Celebró su 150 aniversario el 31 de mayo de 2009. La torre se completó en 1858 y el reloj comenzó a funcionar el 7 de septiembre de 1859. La torre de Big Ben es un icono cultural británico, ya que es uno de los símbolos más prominentes de Reino Unido y frecuentemente aparece como plano de establecimiento en películas, series de televisión, programas o documentales ambientados en Londres."));
        monumentos.add(new cMonumento("@drawable/casa_batllo", "Casa Batllo", "Europa", "España", "Barcelona", "https://es.wikipedia.org/wiki/Casa_Batll%C3%B3", "https://www.google.com/maps/place/Casa+Batll%C3%B3/@41.3916047,2.1625536,17z/data=!3m1!4b1!4m5!3m4!1s0x12a4a2ed494b4161:0x40d2782f9e2e4e0f!8m2!3d41.3917!4d2.164918","La Casa Batlló es un edificio obra del arquitecto Antoni Gaudí, máximo representante del modernismo catalán. Se trata de una remodelación integral de un edificio previamente existente en el solar, obra de Emilio Sala Cortés. Está situado en el número 43 del paseo de Gracia de Barcelona, la ancha avenida que atraviesa el distrito del Eixample, en la llamada Manzana de la discordia, porque alberga además de este edificio otras obras de arquitectos modernistas: la casa Amatller, que colinda con la de Gaudí, obra de Josep Puig i Cadafalch; la Casa Lleó Morera, obra de Lluís Domènech i Montaner; la Casa Mulleras, de Enric Sagnier; y la Casa Josefina Bonet, de Marceliano Coquillat. La construcción se realizó entre los años 1904 y 1906."));
        monumentos.add(new cMonumento("@drawable/cristo_redentor", "Cristo Redentor", "America", "Brasil", "Rio de Janeiro", "https://es.wikipedia.org/wiki/Cristo_Redentor", "https://www.google.com/maps/place/Cristo+Redentor/@7.2254197,-60.100514,3z/data=!4m8!1m2!2m1!1sCristo+Redentor!3m4!1s0x0:0x9dc984d7019502de!8m2!3d-22.9482769!4d-43.2092285","El Cristo Redentor o Cristo del Corcovado es una enorme estatua de Jesús de Nazaret con los brazos abiertos mostrando a la ciudad de Río de Janeiro, Brasil. La estatua tiene una altura de 30,1 metros sobre un pedestal de 8 metros. Este monumento fue inaugurado el 12 de octubre de 1931, después de aproximadamente cinco años de construcción. Considerada la estatua Art decó más grande del mundo, es reconocida como una de las nuevas siete maravillas del mundo moderno junto a Machu Picchu, la Gran Muralla China, el Coliseo de Roma, el Taj Mahal, Chichén Itzá y Petra."));
        monumentos.add(new cMonumento("@drawable/opera_sydney", "Opera de Sydney", "Oceania", "Australia", "Sydney", "https://es.wikipedia.org/wiki/%C3%93pera_de_S%C3%ADdney", "https://www.google.com/maps?safe=strict&sxsrf=ACYBGNRVlQg_NFHlExxepjbPZ-RPOiad2w:1576149651268&q=Opera+de+Sydney&uact=5&um=1&ie=UTF-8&sa=X&ved=2ahUKEwir4ai0_6_mAhWKHxQKHcA3A6EQ_AUoAnoECAwQBA","La Ópera de Sídney o Casa de la Ópera de Sídney, situada en la ciudad de Sídney, estado de Nueva Gales del Sur, Australia, es uno de los edificios más famosos y distintivos del siglo XX. Declarado en 2007 Patrimonio de la Humanidad, fue diseñado por el arquitecto danés Jørn Utzon en 1957 e inaugurado el 20 de octubre de 1973 por su majestad la reina Isabel II, en su papel de reina de Australia. En el edificio se realizan obras de teatro, ballet, ópera o producciones musicales. Es sede de la compañía Ópera Australia, la Compañía de Teatro de Sídney y la Orquesta Sinfónica de Sídney."));
        monumentos.add(new cMonumento("@drawable/torre_tokio", "Torre de Tokio", "Asia", "Japon", "Tokio", "https://es.wikipedia.org/wiki/Torre_de_Tokio", "https://www.google.com/maps/place/Torre+de+Tokio/@35.6585805,139.7432442,17z/data=!3m1!4b1!4m5!3m4!1s0x60188bbd9009ec09:0x481a93f0d2a409dd!8m2!3d35.6585805!4d139.7454329","La Torre de Tokio o Tokyo Tower es una torre que se encuentra en Minato-ku (Tokio, Japón). Está pintada en blanco y rojo de acuerdo a regulaciones de aviación. Su construcción fue terminada el 14 de octubre de 1958 y fue abierta al público el 23 de diciembre del mismo año. La torre mide 332,6 metros de altura, 8.6 más que la Torre Eiffel, aunque no es tan conocida como la edificación francesa. Pesa unas 4000 toneladas, a diferencia de las 10 100 toneladas métricas de la Torre Eiffel. Su función principal es como antena de transmisión de señales analógicas, y desde el 2003 transmite en digital para el área de Kanto. Es una de las principales atracciones turísticas de Tokio."));
        monumentos.add(new cMonumento("@drawable/partenon", "Partenon", "Europa", "Grecia", "Atenas", "https://es.wikipedia.org/wiki/Parten%C3%B3n", "https://www.google.com/maps?safe=strict&sxsrf=ACYBGNT1mP_3o3OyBOH-fRrPH0_w63CJOA:1576149902615&q=Partenon&uact=5&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjjts-7gLDmAhV1A2MBHcmoBhIQ_AUoAnoECBAQBA","El Partenón, es un templo consagrado a la protectora de Atenas, Atenea Partenos y uno de los principales templos dóricos, octástilo, algo poco frecuente, de mármol blanco del Pentélico y cubierto con tejas de mármol de Paros, que se conservan. Fue construido entre los años 447 a. C. y 432 a. C."));
        monumentos.add(new cMonumento("@drawable/capilla_sixtina", "Capilla Sixtina", "Europa", "El Vaticano", "Ciudad del Vaticano", "https://es.wikipedia.org/wiki/Capilla_Sixtina", "https://www.google.com/maps/place/Sistine+Chapel/@41.9029468,12.4522948,17z/data=!3m1!4b1!4m5!3m4!1s0x132f6065c523afdb:0xab16c8877fb53e22!8m2!3d41.9029468!4d12.4544835","La Capilla Sixtina es una capilla del Palacio Apostólico de la Ciudad del Vaticano, la residencia oficial del papa. Se trata de la estancia más conocida del conjunto palaciego. Originalmente servía como capilla de la fortaleza vaticana."));
        monumentos.add(new cMonumento("@drawable/piramides_guiza", "Piramides de Guiza", "Africa", "Egipto", "Guiza", "https://es.wikipedia.org/wiki/Gran_Pir%C3%A1mide_de_Guiza", "https://www.google.com/maps/place/Gran+Pir%C3%A1mide+de+Guiza/@29.9792345,31.1320132,17z/data=!3m1!4b1!4m5!3m4!1s0x14584587ac8f291b:0x810c2f3fa2a52424!8m2!3d29.9792345!4d31.1342019","La Gran Pirámide de Guiza (también conocida como pirámide de Keops o de Jufu) es la más antigua de las siete maravillas del mundo y la única que aún perdura, además de ser la mayor de las pirámides de Egipto. Fue ordenada construir por el faraón Keops de la cuarta dinastía del Antiguo Egipto. El arquitecto de dicha obra es Hemiunu. La fecha estimada de terminación de la construcción de la Gran Pirámide es alrededor de 2570 a. C., siendo la primera y mayor de las tres grandes pirámides de la Necrópolis de Guiza, situada en las afueras de El Cairo, en Egipto. Fue el edificio más alto de la Tierra durante 3800 años, hasta que en el siglo XIV fue superado por el chapitel de la Catedral de Lincoln, en Inglaterra, y el edificio de piedra más alto del mundo hasta bien entrado el siglo XIX, siendo entonces superado por la aguja de la iglesia de San Nikolai, en Hamburgo."));
        monumentos.add(new cMonumento("@drawable/piramide_kukulkan", "Piramide de Kukulkan", "America", "Mexico", "Tinum", "https://es.wikipedia.org/wiki/Templo_de_Kukulk%C3%A1n", "https://www.google.com/maps/place/El+Castillo/@20.6829859,-88.5708378,17z/data=!3m1!4b1!4m5!3m4!1s0x8f5138b88e232523:0x1ef4200c7824ddf!8m2!3d20.6829859!4d-88.5686491","El templo de Kukulkán, es un edificio prehispánico ubicado en la península de Yucatán, en el actual estado del mismo nombre. El actual templo fue construido en el siglo XII d. C. por los mayas itzaes en su capital, la ciudad prehispánica de Chichén Itzá, fundada originalmente en el siglo VI d. C."));
        monumentos.add(new cMonumento("@drawable/gran_muralla_china", "Gran Muralla China", "Asia", "China", "Frontera Norte", "https://es.wikipedia.org/wiki/Gran_Muralla_China", "https://www.google.com/maps/place/Muralla+China/@40.4319077,116.5681862,17z/data=!3m1!4b1!4m5!3m4!1s0x35f121d7687f2ccf:0xd040259b950522df!8m2!3d40.4319077!4d116.5703749","La Gran muralla china es una antigua fortificación china construida y reconstruida entre el siglo V a. C. y el siglo XVI (Edad Moderna) para proteger la frontera norte del Imperio chino durante las sucesivas dinastías imperiales de los ataques de los nómadas xiongnu de Mongolia y Manchuria. Contando sus ramificaciones y construcciones secundarias, se calcula que tiene sobre unos 21.200 kilómetros de largo, desde la frontera con Corea, al borde del río Yalu, hasta el desierto de Gobi, a lo largo de un arco que delinea aproximadamente el borde sur de Mongolia Interior, aunque hoy solo se conserva un 30 % de ella. En promedio, mide de 6 a 7 metros de alto y de 4 a 5 metros de ancho. La muralla fue designada Patrimonio de la Humanidad por la Unesco en 1987. El 26 de enero de 2007 se dio a conocer que la muralla china fue elegida como una de las ganadoras en la lista de Las Nuevas Siete Maravillas del Mundo Moderno."));
        monumentos.add(new cMonumento("@drawable/machu_picchu", "Machu Picchu", "America", "Peru", "Cusco", "https://es.wikipedia.org/wiki/Machu_Picchu", "https://www.google.com/maps/search/machu+picchu/@-13.1567992,-72.550249,14z","Machu Picchu es una ciudadela inca ubicada en las alturas de las montañas de los Andes en Perú, sobre el valle del río Urubamba. Se construyó en el siglo XV y luego fue abandonada, y es famosa por sus sofisticadas paredes de piedra seca que combinan enormes bloques sin el uso de un mortero, los edificios fascinantes que se relacionan con las alineaciones astronómicas y sus vistas panorámicas. El uso exacto que tuvo sigue siendo un misterio."));
        monumentos.add(new cMonumento("@drawable/catedral_san_basilio", "Catedral de San Basilio", "Europa", "Rusia", "Moscu", "https://es.wikipedia.org/wiki/Catedral_de_San_Basilio", "https://www.google.com/maps/place/Catedral+de+San+Basilio/@55.7525229,37.6208981,17z/data=!3m1!4b1!4m5!3m4!1s0x46b54a5962e69605:0xa4cf168ae7cb3ae5!8m2!3d55.7525229!4d37.6230868","La Catedral de la Intercesión de la Santísima Virgen en el Montículo, más conocida como Catedral de San Basilio, es un templo ortodoxo localizado en la Plaza Roja de la ciudad de Moscú, Rusia. Es mundialmente famosa por sus cúpulas en forma de bulbo. Como parte de la Plaza Roja, la catedral de San Basilio fue incluida desde 1990, junto con el conjunto del Kremlin, en la lista de Patrimonio de la Humanidad de Unesco."));
        monumentos.add(new cMonumento("@drawable/templo_ramses", "Templo de Ramsés II", "Africa", "Egipto", "Nubia", "https://es.wikipedia.org/wiki/Templo_de_Rams%C3%A9s_II_(Abu_Simbel)", "https://www.google.com/maps/search/Abu+Simbel/@22.3779587,31.5703126,13z/data=!3m1!4b1","El templo de Ramsés II o templo Mayor de Abu Simbel fue construido bajo el mandato del tercer faraón egipcio de la Dinastía XIX, Ramsés II. Forma parte, junto con el Templo de Nefertari, del complejo de Abu Simbel."));
        monumentos.add(new cMonumento("@drawable/sky_tower", "Sky Tower", "Oceania", "Nueva Zelanda", "Auckland", "https://es.wikipedia.org/wiki/Sky_Tower", "https://www.google.com/maps/place/Sky+Tower/@-36.848448,174.7600023,17z/data=!3m1!4b1!4m5!3m4!1s0x6d0d47f06d4bdc25:0x2d1b5c380ad9387!8m2!3d-36.848448!4d174.762191","La Sky Tower en Auckland, Nueva Zelanda tiene 330 metros de altura, por lo que es considerada el edificio más alto de Nueva Zelanda. Aquí podrás subirte a un ascensor de cristal para que te lleve a una de las tres plataformas de observación disponibles o reservar una mesa en Orbit, un restaurante giratorio. A 200 metros puedes caminar alrededor de la torre en el SkyWalk. O si deseas una emoción extra, puedes saltar en bungee desde la pérgola de 200 metros."));
        monumentos.add(new cMonumento("@drawable/buda_tian_tan", "Buda Tian Tan", "Asia", "China", "Hong Kong", "https://es.wikipedia.org/wiki/Buda_Tian_Tan", "https://www.google.com/maps/place/Buda+Tian+Tan/@22.2539847,113.9027953,17z/data=!3m1!4b1!4m5!3m4!1s0x340158f66af64e31:0x4d0fe4264be5f070!8m2!3d22.2539847!4d113.904984","El Buda Tian Tan, más conocido como Buda Gigante, es una estatua gigante de bronce de un buda Amoghasiddhi ubicado en Ngong Ping, Isla de Lantau, en Hong Kong, adyacente al Monasterio de Po Lin. Simboliza la armonía entre la persona, la naturaleza, la gente y la religión."));
        monumentos.add(new cMonumento("@drawable/obelisco", "Obelisco", "America", "Argentina", "Buenos Aires", "https://es.wikipedia.org/wiki/Obelisco_de_Buenos_Aires", "https://www.google.com/maps?q=Obelisco+de+Buenos+Aires&safe=strict&stick=H4sIAAAAAAAAAG1Tv2_UMBTGVVu17lWqgirKTVUnxMAlTpzkGEC0YqOqBJXYiOo4iS-XOLnYzeUywQYSU2cmZhb-BEZuZGBBYkACwcDekaZ1cgixvc_vve97P_zWVvbWB-lAN3EUE7SdZvw0DbjMxC4Ndk_SoBj5J3Ow1oQ4KHeVSYt6MgeLRGUbQ1qWrW3TMFS2HQ9jR6UymVD1jEvOojnYGEQDA-kCISZbhOJKd5wWmdhMPG8Oepco4Uyahmgh43yK7UWmcEsLzwFsFPyUWp6u5JjjDEUT1lSHSsaNuq3PKqg_B5sNgUGmlGAzJYoCM0TxwulEM1YQ0qlVoTsRHWJ2JVGHxnVqp62gYY7taNoVnWCeR4XSQMUQkXZYhjPOy46DE2kbKsxyipyYCkSySr1cAeaRWNCOvJgyq8wVzGVVhU6zLzVMvXSjWDknduJxPWfdFpKJS9qybM8scTtKlEte2-0cfDwUudUUcyU5YeNxrVMVSxgpJsO2n5Ay2vIbKeI47LojFa-I4uCmHeXTqdV1MTU91138j9ojvtVlUoFj1v4jYY65kjZTu_b9b-BsaWPr1_nX6_2XS2fvPn4GL5bg8n4gpHYO4MaTQB5nhxkdhTPtJ9C-A7j1KMtEkMweB8mJDOhxpiG4-pDLkZxpfdjrXx2Aj5Nb1_oQdqjf24Obz649393-_fTgg_bmH-7XQHsF4PphkJKgEEehtg_hQZYkgS9HGdcseLO_PfC7h0F7feJC5Qb8v2vPRfanH1_er-gQLq61fzkIlMRRcnt1bXkL7AB8705-_-5fMb23KztHJEhGws-a694_DfjFnT8YFYH4A2aNe30HBAAA&sxsrf=ACYBGNRDY4Dm1jQK_yzJ8pcUjwNlBMTQ1g:1576261436141&biw=1536&bih=706&dpr=1.25&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjgk52woLPmAhWGmBQKHe-ICi0Q_AUoAnoECBIQBA","El Obelisco de Buenos Aires es un monumento histórico considerado un ícono de la ciudad de Buenos Aires, construido en 1936 con motivo del cuarto centenario de la llamada primera fundación de la ciudad por Pedro de Mendoza. Está emplazado en la Plaza de la República, en la intersección de las avenidas Corrientes y 9 de Julio, en el barrio de San Nicolás en la Ciudad de Buenos Aires."));


        monumentosFiltrat.clear();
        if(monumentosFiltrat.size() < monumentos.size()) {
            for (int i = 0; i < monumentos.size(); i++) {
                monumentosFiltrat.add(monumentos.get(i));
            }
        }

        // Construim l'adaptador utilitzant un layout per defecte de Android.
        //AdaptadorElemento adaptador = new AdaptadorElemento(this, elements);

        AdaptadorElemento adaptador = new AdaptadorElemento(this, monumentosFiltrat); //elementsFiltrat

        // Assignem al listview l'adaptador creat
        lst = (android.widget.ListView) findViewById(R.id.listMonumentos);
        lst.setAdapter(adaptador);

        // Capturem el clic d'un element de la listview
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                cMonumento monumento = (cMonumento) a.getItemAtPosition(position);

                Intent detalle = new Intent(ListView.this, Info_monumento.class);
                detalle.putExtra("url", monumento.getUrl());
                detalle.putExtra("nombre", monumento.getNombre());
                detalle.putExtra("continente", monumento.getContinente());
                detalle.putExtra("pais", monumento.getPais());
                detalle.putExtra("ciudad", monumento.getCiudad());
                detalle.putExtra("imagen", monumento.getImagen());
                detalle.putExtra("informacion", monumento.getInformacion());
                detalle.putExtra("ubicacion", monumento.getUbicacion());

                startActivity(detalle);
            }


        });
    }

    public void filtro(String tipo){

        ArrayList<cMonumento> listaMonumento = new ArrayList<>();
        listaMonumento.clear();

        List<cMonumento> list = monumentos;

        for (int i = 0; i < list.size(); i++) {
            cMonumento monumento = list.get(i);
            if(tipo == "TODOS") {
                listaMonumento.addAll(monumentos);       //no va, arreglar en clas
                break;
            }
            else if (monumento.getContinente().equals(tipo)) {
                listaMonumento.add(monumento);
            }
        }

        AdaptadorElemento adaptador2 = new AdaptadorElemento(this, listaMonumento);
        lst.setAdapter(adaptador2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Capturar pulsacions en el menú de la barra superior.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.btnMenuMaps:  //nose porque el id se cambia solo
                Intent intentJuego = new Intent(this, Niveles.class);
                startActivity(intentJuego);
                finish();
                return true;
            case R.id.todos:
                filtro("TODOS");
                break;
            case R.id.europa:
                filtro("Europa");
                break;
            case R.id.america:
                filtro("America");
                break;
            case R.id.asia:
                filtro("Asia");
                break;
            case R.id.africa:
                filtro("Africa");
                break;
            case R.id.oceania:
                filtro("Oceania");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

class AdaptadorElemento extends ArrayAdapter<cMonumento> {
    private Context cont;

    public AdaptadorElemento(Context context, ArrayList<cMonumento> elementsFiltrat) {
        super(context, R.layout.layout_monumento, elementsFiltrat);
        cont = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_monumento, null);

        cMonumento Monumento = (cMonumento) getItem(position);

        TextView tvNombre = (TextView) item.findViewById(R.id.tvNombre);     /*nombre por definir*/
        tvNombre.setText(Monumento.getNombre());

        TextView tvContinente = (TextView) item.findViewById(R.id.tvContinente);    /*nombre por definir*/
        tvContinente.setText("Continente: " + Monumento.getContinente());

        TextView tvPais = (TextView) item.findViewById(R.id.tvPais);    /*nombre por definir*/
        tvPais.setText("Pais: " + Monumento.getPais());

        TextView tvCiudad = (TextView) item.findViewById(R.id.tvCiudad);    /*nombre por definir*/
        tvCiudad.setText("Ciudad: " + Monumento.getCiudad());

        /*Drawable originalDrawable = cont.getResources().getIdentifier(Monumento.getImagen());
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(cont.getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        ImageView imgMonumento = (ImageView) item.findViewById(R.id.imagenMonumento);

        imgMonumento.setImageDrawable(roundedDrawable);*/

        //imgMonumento.setImageResource(Monumento.getImagen());

        ImageView imgMonumento = (ImageView) item.findViewById(R.id.imagenMonumento);
        imgMonumento.setImageResource(cont.getResources().getIdentifier(Monumento.getImagen(), "drawable", cont.getOpPackageName()));

        return (item);
    }
}
