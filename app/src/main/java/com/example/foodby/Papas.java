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

public class Papas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papas);

        ImageView Regresar = (ImageView) findViewById(R.id.papaBack);
        Button Agregar = (Button) findViewById(R.id.papaCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.papaCantidad);
        RadioButton a1 = (RadioButton) findViewById(R.id.PA1);
        RadioButton a2 = (RadioButton) findViewById(R.id.PA2);
        RadioButton a3 = (RadioButton) findViewById(R.id.PA3);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(a1.isChecked() == true){
                            DE = "Papas Saladas";
                            CarritoCompra.AgregarCarrito(pos,DE, can,20);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(a2.isChecked() == true){
                            DE = "Papas sabor Queso";
                            CarritoCompra.AgregarCarrito(pos,DE, can,20);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(a3.isChecked() == true){
                            DE = "Papas Enchiladas";
                            CarritoCompra.AgregarCarrito(pos,DE, can,20);
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
                Intent intent = new Intent(view.getContext(), BotanasPopulares.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

    }
}