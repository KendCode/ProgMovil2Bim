package com.example.recyrcleyview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyrcleyview.adapter.ListaAdapterProducto;
import com.example.recyrcleyview.mode.productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaRecyrcleViewPersona;
    ArrayList<productos> listaProducto = new ArrayList<productos>();

    ListaAdapterProducto listaAdapterProducto;
    private EditText txtNom, txtDes, txtPrecio;
    private Button btnA;

    ArrayList<String> productos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cargarR();
        cargadoListaProducto();
        agregarProducto();
    }

    public  void cargarR(){
        listaRecyrcleViewPersona = (RecyclerView) findViewById(R.id.listaRpersona);
        txtNom=(EditText) findViewById(R.id.txtNom);
        txtDes=(EditText) findViewById(R.id.txtDes);
        txtPrecio=(EditText) findViewById(R.id.txtPrecio);
        btnA=(Button) findViewById(R.id.btnA);
    }
    public  void  cargadoListaProducto(){
        //listaRecyrcleViewPersona.setLayoutManager(new LinearLayoutManager(this));
        //listaProducto.add(new productos("laptop", "conputadora de escritorio", 1200));
        //listaProducto.add(new productos("laptop", "conputadora de escritorio", 1200));
        //listaAdapterProducto = new ListaAdapterProducto(listaProducto);
        //listaRecyrcleViewPersona.setAdapter(listaAdapterProducto);
        //listaProducto= new ArrayList <productos>();
        listaRecyrcleViewPersona.setLayoutManager(new LinearLayoutManager(this));
        listaProducto.add(new productos("laptop", "conputadora de escritorio", 1200));
        listaAdapterProducto = new ListaAdapterProducto(listaProducto);
        listaRecyrcleViewPersona.setAdapter(listaAdapterProducto);
    }
    public void agregarProducto(){
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNom.getText().toString();
                String descripcion = txtDes.getText().toString();
                
                double precio = Double.parseDouble(txtPrecio.getText().toString());

                listaProducto.add(new productos(nombre, descripcion, (int) precio));
                listaRecyrcleViewPersona.setAdapter(listaAdapterProducto);

                txtNom.setText("");
                txtDes.setText("");
                txtPrecio.setText("");
            }
        });
    }
}