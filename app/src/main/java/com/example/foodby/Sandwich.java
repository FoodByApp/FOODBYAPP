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

public class Sandwich extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);

        ImageView Regresar = (ImageView) findViewById(R.id.sandBack);
        Button Agregar = (Button) findViewById(R.id.sandCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.sandCantidad);
        RadioButton S1 = (RadioButton) findViewById(R.id.sand1);
        RadioButton S2 = (RadioButton) findViewById(R.id.sand2);
        RadioButton S3 = (RadioButton) findViewById(R.id.sand3);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(S1.isChecked() == true){
                            DE = "Sandwich de Pavo";
                            CarritoCompra.AgregarCarrito(pos,DE, can,45);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(S2.isChecked() == true){
                            DE = "Sandwich de Pollo";
                            CarritoCompra.AgregarCarrito(pos,DE, can,45);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(S3.isChecked() == true){
                            DE = "Sandwich de Jamon";
                            CarritoCompra.AgregarCarrito(pos,DE, can,45);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                    } else{
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