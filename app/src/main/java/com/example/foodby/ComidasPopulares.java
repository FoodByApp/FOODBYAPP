package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ComidasPopulares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas_populares);

        ImageView regresar = (ImageView) findViewById(R.id.ComidaBack);
        ImageView Guisado = (ImageView) findViewById(R.id.ComidaGuisado);
        ImageView Sandwich = (ImageView) findViewById(R.id.ComidaSandwich);
        ImageView Pizza = (ImageView) findViewById(R.id.ComidaPizza);
        ImageView Hamburguesa = (ImageView) findViewById(R.id.ComidaHamburguesa);
        ImageView Ensalada = (ImageView) findViewById(R.id.ComidaEnsalada);
        ImageView Bionico = (ImageView) findViewById(R.id.ComidaBionicos);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

        //IR AL MENU DE GUISADOS
        Guisado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Guisados.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        // IR AL MENU DE SANDWICH
        Sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Sandwich.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        // IR AL MENU HAMBURGUESA
        Hamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Hamburguesa.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        // IR AL MENU ENSALADA
        Ensalada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Ensalada.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        //IR AL MENU DE BIONICOS
        Bionico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Bionicos.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        //IR AL MENU DE PIZZA
        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Pizza.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
    }
}