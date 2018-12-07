package com.example.biankatpas.consumirandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AcessoRest ar = new AcessoRest();

        String chamadaWS = "http://192.168.0.117:8084/Produto-WS/webresources/generic/usuario/get/melapso";
        String resultado = ar.exemploGet(chamadaWS);

        Log.i("JSON", resultado);

        try
        {

            Gson g = new Gson();
            Usuario u = new Usuario();

            Type usuarioType = new TypeToken<Usuario>() {}.getType();
            u = g.fromJson(resultado, usuarioType);

            TextView texto = findViewById(R.id.texto);
            texto.setText(String.format("%s\n%s\n%s\n%s", u.getLogin(), u.getSenha(), u.getEmail(), u.getPerfil()));

        }
        catch (Exception ex) { }

    }
}
