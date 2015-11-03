package com.example.thiago.listaicones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new MeuAdapter(this, fonteDados()));
    }

    private List<Field> fonteDados(){
        Field[] campos = android.R.drawable.class.getDeclaredFields();
        List<Field> dados = new ArrayList<Field>();
        for (Field campo: campos){
            if (campo.getName().startsWith("ic_menu_")){
                dados.add(campo);
            }
        }
        return dados;
    }
}
