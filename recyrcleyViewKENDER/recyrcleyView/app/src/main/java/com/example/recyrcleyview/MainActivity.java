package com.example.recyrcleyview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyrcleyview.adapter.ListaAdapterProducto;
import com.example.recyrcleyview.model.Productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaRecyrcleyViewPersona;

    ArrayList<Productos> listaProductos = new ArrayList<Productos>();

    ListaAdapterProducto listaAdapterProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cargarR();
        cargadoListaProducto();
    }
    public  void cargarR(){
        listaRecyrcleyViewPersona = (RecyclerView) findViewById(R.id.listaRPersona);
    }
    public  void cargadoListaProducto(){
        listaRecyrcleyViewPersona.setLayoutManager(new LinearLayoutManager(this));
        listaProductos.add(new Productos("laptop","computadora de escritorio",1200));
        listaProductos.add(new Productos("laptop escritorio","computadora de escritorio",1200));
        listaAdapterProducto = new ListaAdapterProducto(listaProductos);
        listaRecyrcleyViewPersona.setAdapter(listaAdapterProducto);
    }
}