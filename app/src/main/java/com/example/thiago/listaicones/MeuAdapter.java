package com.example.thiago.listaicones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Thiago on 02/11/2015.
 */
public class MeuAdapter extends ArrayAdapter<Field> {

    private final Context context;
    private List<Field> dados;

    public MeuAdapter(Context context, List<Field> dados){
        super(context, R.layout.linhalista, dados);
        this.context = context;
        this.dados = dados;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linhalista, parent, false);
        Field atual = dados.get(position);
        int resourceId = 0;

        try {
            resourceId = atual.getInt(new Object());
        }catch (Exception e){
        }
        ImageView icone = (ImageView) view.findViewById(R.id.icone);
        icone.setImageResource(resourceId);
        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        titulo.setText(atual.getName());
        return view;
    }
}
