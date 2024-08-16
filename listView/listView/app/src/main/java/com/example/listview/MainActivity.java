package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lp;
    private TextView tvR;
    private EditText txtpais,txtpoblacion;
    private Button btnAgregar;
    ArrayList<String> paises;
    ArrayList<String> habitantes;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cargarR();
        llenadoPaises();
        AgrgarPais();
    }
    public void cargarR(){
        lp = (ListView) findViewById(R.id.listaPaises);
        tvR = (TextView) findViewById(R.id.tvResul);
        txtpais = (EditText) findViewById(R.id.txtpais);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        txtpoblacion = (EditText) findViewById(R.id.txtpoblacion);
    }
    public void llenadoPaises(){
        //String [] paises = {"Bolivia","Peru","Argentina","Chile","Paraguay","Brasil","Venezuela","Ecuador","Colombia"};

        paises = new ArrayList<String>();
        paises.add("Bolivia");


        //String [] habitantes = {"25550","32145","845621","32165","782125","87711","23158","751325","784156"};
        habitantes = new ArrayList<String>();
        habitantes.add("25550");

        arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,paises);


        lp.setAdapter(arrayAdapter);
        lp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "La poblacion de: "+lp.getItemAtPosition(position)+"es de: "+habitantes[position],Toast.LENGTH_SHORT).show();
                tvR.setText("La poblacion de "+lp.getItemAtPosition(position)+" es de: "+habitantes.get(position));
            }
        });
    }
    public void AgrgarPais(){
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paises.add(txtpais.getText().toString());
                habitantes.add(txtpoblacion.getText().toString());
                lp.setAdapter(arrayAdapter);
            }
        });
    }
}