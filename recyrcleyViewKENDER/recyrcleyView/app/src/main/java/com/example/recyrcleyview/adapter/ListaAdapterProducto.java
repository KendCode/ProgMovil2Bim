package com.example.recyrcleyview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyrcleyview.R;
import com.example.recyrcleyview.model.Productos;

import java.util.ArrayList;

public class ListaAdapterProducto  extends RecyclerView.Adapter<ListaAdapterProducto.listaProductoViewHolder> {

    public ListaAdapterProducto(ArrayList<Productos> listaProducto) {
        this.listaProducto = listaProducto;
    }

    ArrayList<Productos> listaProducto;


    //LA CONEXION CON NUESTRA INTERFAZ

    @NonNull
    @Override
    public ListaAdapterProducto.listaProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_productos, null, false);
        return new listaProductoViewHolder(view);
    }
    //CONEXION CON NUESTRA CLASE CLIENTE Y MIS IDENTIFICADORES
    @Override
    public void onBindViewHolder(@NonNull ListaAdapterProducto.listaProductoViewHolder holder, int position) {
        holder.tvN.setText(listaProducto.get(position).getNombre());
        holder.tvP.setText(String.valueOf(listaProducto.get(position).getPrecio()));
        holder.tvD.setText(listaProducto.get(position).getDescripcion());
    }
    //TAMAÑO DE MI LISTA DE CLIENTES
    @Override
    public int getItemCount() {
        return listaProducto.size();
    }
    //LA CONEXION O PUENTE ENTRE EL XML Y LA CLSE R.
    public class listaProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvN, tvP, tvD;
        public listaProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvN = itemView.findViewById(R.id.txtNombre);
            tvP = itemView.findViewById(R.id.txtPrecio);
            tvD = itemView.findViewById(R.id.txtDescripcion);
        }
    }
}
