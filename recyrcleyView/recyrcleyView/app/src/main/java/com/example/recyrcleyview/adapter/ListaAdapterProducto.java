package com.example.recyrcleyview.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyrcleyview.R;
import com.example.recyrcleyview.mode.productos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaAdapterProducto extends RecyclerView.Adapter<ListaAdapterProducto.listaProductoViewHolder> {

    public ListaAdapterProducto(ArrayList<productos> listaProducto) {
        this.listaProducto = listaProducto;
    }

    ArrayList<productos> listaProducto;
    // conexion con nuestra interfaz
    @NonNull
    @Override
    public ListaAdapterProducto.listaProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_producto,null,false);
        return new listaProductoViewHolder(view);
    }
    //conexion con clase clientes y mis identificadores
    @Override
    public void onBindViewHolder(@NonNull ListaAdapterProducto.listaProductoViewHolder holder, int position) {
        holder.tvN.setText(listaProducto.get(position).getNombre());
        holder.tvP.setText(String.valueOf(listaProducto.get(position).getPrecio()));
        holder.tvD.setText(listaProducto.get(position).getDescripcion());
    }

    //el tamaño de mi lista de clientes
    @Override
    public int getItemCount() {
        return listaProducto.size();
    }
    //la conexion o el punte entre el xml y la clase R
    public class listaProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvN, tvP, tvD;
        public listaProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvN = itemView.findViewById(R.id.txtNombre);
            tvP = itemView.findViewById(R.id.txtprecio);
            tvD = itemView.findViewById(R.id.txtdescripción);
        }
    }
}
