package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.foodby.ui.CarritoCompra;

public class Jugo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugo);

        ImageView Regresar = (ImageView) findViewById(R.id.jugoBack);
        Button Agregar = (Button) findViewById(R.id.jugoCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.jugoCantidad);
        RadioButton j1 = (RadioButton) findViewById(R.id.J1);
        RadioButton j2 = (RadioButton) findViewById(R.id.J2);
        RadioButton j3 = (RadioButton) findViewById(R.id.J3);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(j1.isChecked() == true){
                            DE = "Jugo de Naranja";
                            CarritoCompra.AgregarCarrito(pos,DE, can,15);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(j2.isChecked() == true){
                            DE = "Jugo de Piña";
                            CarritoCompra.AgregarCarrito(pos,DE, can,15);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(j3.isChecked() == true){
                            DE = "Jugo de Manzana";
                            CarritoCompra.AgregarCarrito(pos,DE, can,15);
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
                Intent intent = new Intent(view.getContext(), BebidasPopulares.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

    }
}