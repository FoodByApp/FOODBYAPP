package com.example.foodby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrarse extends AppCompatActivity {

    private DatabaseReference Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        Registrar = FirebaseDatabase.getInstance().getReference();

        ImageView regresar = (ImageView) findViewById(R.id.RegBack);

        TextView Nombre = (TextView) findViewById(R.id.RegNom);
        TextView NumControl = (TextView) findViewById(R.id.RegNum);
        TextView Contraseña = (TextView) findViewById(R.id.RegPass);
        TextView Direccion = (TextView) findViewById(R.id.RegDir);
        Button Registro = (Button) findViewById(R.id.RegReg);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Nombre.getText().toString();
                String pass = Contraseña.getText().toString();
                String adress = Direccion.getText().toString();
                String pedidos = "";
                String num = NumControl.getText().toString();
                int NumCont = Integer.parseInt(NumControl.getText().toString());

                if(!name.equals("") && !pass.equals("") && !adress.equals("") && !num.equals("")){
                    RegistrarUsuario User = new RegistrarUsuario(name, adress, pass, pedidos, NumCont);
                    Registrar.child("Usuarios").child(num).setValue(User);

                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(intent, 0);
                    Toast wellcome = Toast.makeText(getApplicationContext(), "Gracias Por Registrarse", Toast.LENGTH_SHORT);
                    wellcome.show();
                    finish();
                }else{
                    Toast Error = Toast.makeText(getApplicationContext(), "Los campos no deben estar vacios", Toast.LENGTH_SHORT);
                    Error.show();
                }
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}