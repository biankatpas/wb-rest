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

        try
        {

            Gson g = new Gson();
            Usuario u = new Usuario();
            Produto p = new Produto();

            int type = 2;

            switch (type)
            {
                case 1:
                    //        String chamadaWS = "http://192.168.0.117:8084/Produto-WS/webresources/generic/usuario/get/melapso";
                    String chamadaWS = "http://10.7.24.137:8084/Produto-WS/webresources/generic/usuario/get/melapso";
                    String resultado = ar.exemploGet(chamadaWS);
                    Log.i("JSON", resultado);

                    Type usuarioType = new TypeToken<Usuario>() {}.getType();
                    u = g.fromJson(resultado, usuarioType);

                    TextView texto = findViewById(R.id.texto);
                    texto.setText(String.format("%s\n%s\n%s\n%s", u.getLogin(), u.getSenha(), u.getEmail(), u.getPerfil()));

                    break;
                case 2:

                    //        String chamadaWS = "http://192.168.0.117:8084/Produto-WS/webresources/generic/usuario/get/melapso";
                    String chamadaWS2 = "http://10.7.24.137:8084/Produto-WS/webresources/generic/produto/get/tofu";
                    String resultado2 = ar.exemploGet(chamadaWS2);
                    Log.i("JSON", resultado2);

                    Type produtoType = new TypeToken<Produto>() {}.getType();
                    p = g.fromJson(resultado2, produtoType);

                    TextView texto2 = findViewById(R.id.texto);
                    texto2.setText(String.format("%s\n%s\n%s", p.getDescricao(), p.getVencimento(), p.getVendedor()));

                    break;
                default:

            }



        }
        catch (Exception ex) { }

    }
}
