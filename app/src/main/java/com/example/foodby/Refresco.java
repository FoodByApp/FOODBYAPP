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

public class Refresco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresco);

        ImageView Regresar = (ImageView) findViewById(R.id.refreBack);
        Button Agregar = (Button) findViewById(R.id.refreCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.refreCantidad);
        RadioButton r1 = (RadioButton) findViewById(R.id.R1);
        RadioButton r2 = (RadioButton) findViewById(R.id.R2);
        RadioButton r3 = (RadioButton) findViewById(R.id.R3);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(r1.isChecked() == true){
                            DE = "Coca-Cola";
                            CarritoCompra.AgregarCarrito(pos,DE, can,13);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(r2.isChecked() == true){
                            DE = "Fanta";
                            CarritoCompra.AgregarCarrito(pos,DE, can,13);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(r3.isChecked() == true){
                            DE = "Sprite";
                            CarritoCompra.AgregarCarrito(pos,DE, can,13);
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