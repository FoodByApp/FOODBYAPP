package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodby.ui.CarritoCompra;

public class Bionicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bionicos);

        ImageView Regresar = (ImageView) findViewById(R.id.biBack);
        Button Agregar = (Button) findViewById(R.id.biCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.biCantidad);
        CheckBox I1 = (CheckBox) findViewById(R.id.bi1);
        CheckBox I2 = (CheckBox) findViewById(R.id.bi2);
        CheckBox I3 = (CheckBox) findViewById(R.id.bi3);
        CheckBox I4 = (CheckBox) findViewById(R.id.bi4);
        CheckBox I5 = (CheckBox) findViewById(R.id.bi5);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "Bionico";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(I1.isChecked() == false && I2.isChecked() == false && I3.isChecked() == false &&
                                I4.isChecked() == false && I5.isChecked() == false ){
                            Toast add = Toast.makeText(getApplicationContext(), "Seleccione sus ingredientes", Toast.LENGTH_SHORT);
                            add.show();
                        }else{
                            if(I1.isChecked())
                                DE += "Con Platano";
                            if(I2.isChecked())
                                DE += "Con Papaya";
                            if(I3.isChecked())
                                DE += "Con Melon";
                            if(I4.isChecked())
                                DE += "Con Manzana";
                            if(I5.isChecked())
                                DE += "Con Fresa";
                            CarritoCompra.AgregarCarrito(pos,DE, can,35);
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