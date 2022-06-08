package com.example.foodby.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodby.DatosUsuarios;
import com.example.foodby.MainActivity;
import com.example.foodby.Menu;
import com.example.foodby.R;
import com.example.foodby.RegistrarUsuario;
import com.example.foodby.RegistroCompra;
import com.example.foodby.databinding.FragmentSlideshowBinding;
import com.example.foodby.ui.CarritoCompra;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    private DatabaseReference Comprado;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Comprado = FirebaseDatabase.getInstance().getReference();

        TextView Detalles = (TextView) root.findViewById(R.id.CarritoINFO);
        TextView Total = (TextView) root.findViewById(R.id.CarritoTotal);
        String dat = CarritoCompra.getDatos();
        String tot = String.valueOf(CarritoCompra.getTotal());
        Button comprar = (Button) root.findViewById(R.id.CarritoComprar);

        Detalles.setText(dat);
        Total.setText("Total: " + tot);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String detalles = CarritoCompra.getDatos();
                String total = String.valueOf( CarritoCompra.getTotal() );

                RegistroCompra compra = new RegistroCompra(detalles, total);
                Comprado.child("Pedidos").push().setValue(compra);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);

                String PEDIDOS = DatosUsuarios.getPedidosAnteriores();
                PEDIDOS += fecha + "\n" + CarritoCompra.getDatos() + "\n";
                DatosUsuarios.setPedidosAnteriores(PEDIDOS);
                String num = String.valueOf(DatosUsuarios.getNumeroControl());

                RegistrarUsuario User = new RegistrarUsuario(DatosUsuarios.getNombre(), DatosUsuarios.getDireccion(), DatosUsuarios.getContraseña(), DatosUsuarios.getPedidosAnteriores(), DatosUsuarios.getNumeroControl());
                Comprado.child("Usuarios").child(num).setValue(User);

                CarritoCompra.vaciarCarrito();

                Intent intent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(intent, 0);
                Toast Comprado = Toast.makeText(view.getContext(), "Compra Realizada\nGracias Por Su Compra", Toast.LENGTH_SHORT);
                Comprado.show();
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