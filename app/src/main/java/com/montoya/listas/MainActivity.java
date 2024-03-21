package com.montoya.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotoPerfil = {
                R.drawable.eminem,
                R.drawable.snoop,
                R.drawable.ice,
                R.drawable.dre,
                R.drawable.eazy,
        };
        String[] nombres = {
                "Eminem",
                "Snoop Dogg",
                "Ice Cube",
                "Dr. Dre",
                "Eazy-E",
        };
        String[] biografias = {
                "Canciones: Lose Yourself, Stan, The Real Slim Shady, Love the Way You Lie, Not Afraid ",
                "Canciones: Gin and Juice, What’s My Name?, Drop It Like It’s Hot, Beautiful, Nuthin’ But A G Thang",
                "Canciones: It Was A Good Day, Gin and Juice, What’s My Name?, Drop It Like It’s Hot, Beautiful",
                "Canciones: Let Me Ride, Family Affair, Turn Off The Lights, Talk About It, Genocide",
                "Canciones: Nutz On Ya Chin, Eazy-Duz-It, Real Compton G’s, We Want Eazy, Eazy Er Said Than Dunn",
        };
        String[] telefonos = {
                "96969696",
                "418418418",
                "265265265",
                "14161416",
                "384384384",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil,biografias);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Vista, int Posicion, long Id){

                Intent EnviarInfo = new Intent(MainActivity.this, UserActivity.class)
                        .putExtra("Nombre: ", nombres[Posicion])
                        .putExtra("Teléfono: ", telefonos[Posicion])
                        .putExtra("Foto de Perfil: ", fotoPerfil[Posicion])
                        .putExtra("Biografia: ", biografias[Posicion]);
                startActivity(EnviarInfo);
            }
        });

    }
}