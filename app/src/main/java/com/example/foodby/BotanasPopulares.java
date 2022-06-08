package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BotanasPopulares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botanas_populares);

        ImageView Regresar = (ImageView) findViewById(R.id.botanaBack);
        ImageView Galletas = (ImageView) findViewById(R.id.botanaGalleta);
        ImageView Papas = (ImageView) findViewById(R.id.botanaPapas);
        ImageView Chaska = (ImageView) findViewById(R.id.botanaChaska);
        ImageView Pan = (ImageView) findViewById(R.id.botanaPan);

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(intent, 0);
            }
        });
        Galletas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Galletas.class);
                startActivityForResult(intent, 0);
            }
        });
        Papas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Papas.class);
                startActivityForResult(intent, 0);
            }
        });
        Chaska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Chaskas.class);
                startActivityForResult(intent, 0);
            }
        });
        Pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Pan.class);
                startActivityForResult(intent, 0);
            }
        });


    }
}