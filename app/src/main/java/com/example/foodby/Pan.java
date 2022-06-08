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

public class Pan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan);

        ImageView Regresar = (ImageView) findViewById(R.id.panBack);
        Button Agregar = (Button) findViewById(R.id.panCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.panCantidad);
        RadioButton a1 = (RadioButton) findViewById(R.id.pan1);
        RadioButton a2 = (RadioButton) findViewById(R.id.pan2);

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
                            DE = "Concha de Chocolate";
                            CarritoCompra.AgregarCarrito(pos,DE, can,8);
                            Toast add = Toast.makeText(getApplicationContext(), "Agregadoo al carrito", Toast.LENGTH_SHORT);
                            add.show();
                        }
                        if(a2.isChecked() == true){
                            DE = "Concha de Vainilla";
                            CarritoCompra.AgregarCarrito(pos,DE, can,8);
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