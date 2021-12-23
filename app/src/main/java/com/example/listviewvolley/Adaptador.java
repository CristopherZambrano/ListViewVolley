package com.example.listviewvolley;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<ElementosLista> Datos;
    private LayoutInflater inflater;
    private Context contexto;

    public Adaptador(List<ElementosLista> datos, Context contexto) {
        this.Datos = datos;
        this.inflater = LayoutInflater.from(contexto);
        this.contexto = contexto;
    }

    @Override
    public int getItemCount(){return Datos.size();}

    @Override
    public Adaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View vista = inflater.inflate(R.layout.lista_evaluadores,null);
        return new Adaptador.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder (final Adaptador.ViewHolder holder,final int positio){
        holder.bindData(Datos.get(positio));
    }

    public void setDatos (List<ElementosLista> items){ Datos=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView nombres,identificador,area;

        ViewHolder(View itemview){
            super(itemview);
            icon = itemview.findViewById(R.id.iconImageView);
            nombres = itemview.findViewById(R.id.nombre);
            identificador = itemview.findViewById(R.id.identificador);
            area=itemview.findViewById(R.id.area);
        }
        void bindData(final ElementosLista item){
            icon.setColorFilter(Color.parseColor(item.getJPG()), PorterDuff.Mode.SRC_IN);
            nombres.setText(item.getNombres());
            area.setText(item.getArea());
            identificador.setText(item.getIdentificador());
        }
    }
}
