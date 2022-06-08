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

public class Hamburguesa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburguesa);

        ImageView Regresar = (ImageView) findViewById(R.id.hamBack);
        Button Agregar = (Button) findViewById(R.id.hamCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.hamCantidad);
        RadioButton H1 = (RadioButton) findViewById(R.id.ham1);
        RadioButton H2 = (RadioButton) findViewById(R.id.ham2);
        RadioButton H3 = (RadioButton) findViewById(R.id.ham3);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(H1.isChecked() == true){
                            DE = "Hamburguesa Bufalo";
                            CarritoCompra.AgregarCarrito(pos,DE, can,50);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(H2.isChecked() == true){
                            DE = "Hamburguesa de Pavo";
                            CarritoCompra.AgregarCarrito(pos,DE, can,50);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(H3.isChecked() == true){
                            DE = "Hamburguesa Jamon";
                            CarritoCompra.AgregarCarrito(pos,DE, can,50);
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