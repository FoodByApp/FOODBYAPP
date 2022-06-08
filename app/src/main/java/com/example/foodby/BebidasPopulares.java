package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BebidasPopulares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas_populares);

        ImageView Regresar = (ImageView) findViewById(R.id.bebidaBack);
        ImageView Agua = (ImageView) findViewById(R.id.bebidaAgua);
        ImageView Refresco = (ImageView) findViewById(R.id.bebidaRefresco);
        ImageView Yogurt = (ImageView) findViewById(R.id.bebidaYogurt);
        ImageView Jugo = (ImageView) findViewById(R.id.bebidaJugo);
        // Regresar Al Menu
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(intent, 0);
            }
        });
        // Ir Al Menu De Agua
        Agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Agua.class);
                startActivityForResult(intent, 0);
            }
        });
        // IR AL MENU DE YOUGURT
        Yogurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Yogurt.class);
                startActivityForResult(intent, 0);
            }
        });
        //Ir AL Menu Jugo
        Jugo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Jugo.class);
                startActivityForResult(intent, 0);
            }
        });
        //Ir Al Menu Refresco
        Refresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Refresco.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}