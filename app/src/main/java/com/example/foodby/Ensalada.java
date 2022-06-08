package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.foodby.ui.CarritoCompra;

public class Ensalada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensalada);

        ImageView Regresar = (ImageView) findViewById(R.id.enBack);
        Button Agregar = (Button) findViewById(R.id.enCarrito);
        EditText Cantidad = (EditText) findViewById(R.id.enCantidad);
        CheckBox I1 = (CheckBox) findViewById(R.id.en1);
        CheckBox I2 = (CheckBox) findViewById(R.id.en2);
        CheckBox I3 = (CheckBox) findViewById(R.id.en3);
        CheckBox I4 = (CheckBox) findViewById(R.id.en4);
        CheckBox I5 = (CheckBox) findViewById(R.id.en5);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = CarritoCompra.getPos();
                if(pos <= 9){
                    int can = Integer.parseInt(Cantidad.getText().toString());
                    String DE = "Ensalada";
                    String c = Cantidad.getText().toString();
                    if( !c.equals("") ){
                        if(I1.isChecked() == false && I2.isChecked() == false && I3.isChecked() == false &&
                                I4.isChecked() == false && I5.isChecked() == false ){
                            Toast add = Toast.makeText(getApplicationContext(), "Seleccione sus ingredientes", Toast.LENGTH_SHORT);
                            add.show();
                        }else{
                            if(I1.isChecked())
                                DE += "De Pollo";
                            if(I2.isChecked())
                                DE += "Con Lechuga";
                            if(I3.isChecked())
                                DE += "Con Jitomate";
                            if(I4.isChecked())
                                DE += "Con pepino";
                            if(I5.isChecked())
                                DE += "Con Brocoli";
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