package com.example.foodby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private String DName, DPass, DAdress, DNum;

    private DatabaseReference IniciarSecion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView NumControl = (TextView) findViewById(R.id.LogNum);
        TextView Contraseña = (TextView) findViewById(R.id.LogPass);
        Button Iniciar = (Button) findViewById(R.id.LogIni);
        Button Registro = (Button) findViewById(R.id.LogReg);

        IniciarSecion = FirebaseDatabase.getInstance().getReference();

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num = NumControl.getText().toString();
                String pass = Contraseña.getText().toString();

                if(!num.equals("") && !pass.equals("")){
                    IniciarSecion.child("Usuarios").child(num).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                DName = snapshot.child("nombre").getValue().toString();
                                DAdress = snapshot.child("direccion").getValue().toString();
                                DPass = snapshot.child("contraseña").getValue().toString();
                                DNum = snapshot.child("numeroControl").getValue().toString();
                                String peidos = snapshot.child("pedidosAnteriores").getValue().toString();
                                int DDNum = Integer.parseInt(DNum);

                                if(pass.equals(DPass)){
                                    DatosUsuarios.setNombre(DName);
                                    DatosUsuarios.setDireccion(DAdress);
                                    DatosUsuarios.setContraseña(DPass);
                                    DatosUsuarios.setPedidosAnteriores(peidos);
                                    DatosUsuarios.setNumeroControl(DDNum);

                                    Intent intent = new Intent(view.getContext(), Menu.class);
                                    startActivityForResult(intent, 0);
                                    Toast wellcome = Toast.makeText(getApplicationContext(), "Bienvenido" + DName, Toast.LENGTH_LONG);
                                    wellcome.show();
                                    finish();
                                }else{
                                    Toast contraseñaEquivocada = Toast.makeText(getApplicationContext(), "La contraseña no es correcta", Toast.LENGTH_SHORT);
                                    contraseñaEquivocada.show();
                                }
                            }else{
                                Toast Error = Toast.makeText(getApplicationContext(), "Numero de control incorrecto o no esta registrado", Toast.LENGTH_SHORT);
                                Error.show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }else{
                    Toast Error = Toast.makeText(getApplicationContext(), "Los campos no deben estar vacios", Toast.LENGTH_SHORT);
                    Error.show();
                }
            }
        });

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Registrarse.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

    }
}