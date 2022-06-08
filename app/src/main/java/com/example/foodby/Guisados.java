package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.CarrierConfigManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.foodby.ui.CarritoCompra;

public class Guisados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guisados);

        ImageView Regresar = (ImageView) findViewById(R.id.GuisadoBack);
        Spinner comida = (Spinner) findViewById(R.id.spinner);
        String opciones[] = {"Molletes $35","Bolillo $25","Taco $10", "Burrito $30"};
        EditText cantidad = (EditText) findViewById(R.id.GuisadoCantidad);
        Button Agregar = (Button) findViewById(R.id.guisadoCarrito);
        RadioButton g1 = (RadioButton) findViewById(R.id.Guisado1);
        RadioButton g2 = (RadioButton) findViewById(R.id.Guisado2);
        RadioButton g3 = (RadioButton) findViewById(R.id.Guisado3);
        RadioButton g4 = (RadioButton) findViewById(R.id.Guisado4);
        RadioButton g5 = (RadioButton) findViewById(R.id.Guisado5);
        RadioButton g6 = (RadioButton) findViewById(R.id.Guisado6);


        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        comida.setAdapter(adapter);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    String com = comida.getSelectedItem().toString();
                    int can = Integer.parseInt(cantidad.getText().toString());
                    String c = cantidad.getText().toString();
                    String DE = "";
                    if( !c.equals("") ){
                        if(g1.isChecked() == true)
                            DE = "de Chilaquiles";
                        if(g2.isChecked() == true)
                            DE = "de Discada";
                        if(g3.isChecked() == true)
                            DE = "de Mole";
                        if(g4.isChecked() == true)
                            DE = "de Papas";
                        if(g5.isChecked() == true)
                            DE = "de Chicarron Prensado";
                        if(g6.isChecked() == true)
                            DE = "de Desebrada";

                        if(com.equals("Molletes $35")) {
                            CarritoCompra.AgregarCarrito(pos,"Molletes " + DE, can,35);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(com.equals("Bolillo $25")) {
                            CarritoCompra.AgregarCarrito(pos,"Bolillo " + DE, can,25);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(com.equals("Taco $10")) {
                            CarritoCompra.AgregarCarrito(pos,"Taco " + DE, can,10);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(com.equals("Burrito $30")) {
                            CarritoCompra.AgregarCarrito(pos,"Burrito " + DE, can,30);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                    }else{
                        Toast error = Toast.makeText(getApplicationContext(), "Ingrese la cantidad", Toast.LENGTH_SHORT);
                        error.show();
                    }

                }else{
                    Toast lleno = Toast.makeText(getApplicationContext(), "Carrito lleno", Toast.LENGTH_SHORT);
                    lleno.show();
                }
            }
        });

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ComidasPopulares.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

    }
}