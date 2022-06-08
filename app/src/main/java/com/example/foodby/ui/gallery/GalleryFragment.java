package com.example.foodby.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodby.DatosUsuarios;
import com.example.foodby.R;
import com.example.foodby.RegistrarUsuario;
import com.example.foodby.databinding.FragmentGalleryBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    private DatabaseReference Update;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        TextView Nombre = (TextView) root.findViewById(R.id.perName);
        TextView Numero = (TextView) root.findViewById(R.id.perNum);
        EditText Direccion = (EditText) root.findViewById(R.id.perDir);
        Button Actualizar = (Button) root.findViewById(R.id.perAct);

        Update = FirebaseDatabase.getInstance().getReference();

        Nombre.setText("Nombre: " + DatosUsuarios.getNombre());
        Numero.setText("Numero de Control: " + DatosUsuarios.getNumeroControl());
        Direccion.setText(DatosUsuarios.getDireccion());

        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dir = Direccion.getText().toString();
                if( !dir.equals("") ){
                    DatosUsuarios.setDireccion( dir );
                    String num = String.valueOf( DatosUsuarios.getNumeroControl() );
                    RegistrarUsuario User = new RegistrarUsuario(DatosUsuarios.getNombre(), DatosUsuarios.getDireccion(), DatosUsuarios.getContraseña(), DatosUsuarios.getPedidosAnteriores(), DatosUsuarios.getNumeroControl());
                    Update.child("Usuarios").child(num).setValue(User);
                    Toast wellcome = Toast.makeText(view.getContext(), "Datos Actualizados", Toast.LENGTH_SHORT);
                    wellcome.show();
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}