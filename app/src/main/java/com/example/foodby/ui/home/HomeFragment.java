package com.example.foodby.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodby.BebidasPopulares;
import com.example.foodby.BotanasPopulares;
import com.example.foodby.ComidasPopulares;
import com.example.foodby.MainActivity;
import com.example.foodby.R;
import com.example.foodby.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button Comidas = (Button) root.findViewById(R.id.MenuComidas);
        Button Bebidas = (Button) root.findViewById(R.id.MenuBebidas);
        Button Botanas = (Button) root.findViewById(R.id.MenuBotanas);
        // ---- IR AL MENU DE COMIDAS
        Comidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ComidasPopulares.class);
                startActivityForResult(intent, 0);
            }
        });
        // ----IR AL MENU BEBIDAS
        Bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BebidasPopulares.class);
                startActivityForResult(intent, 0);
            }
        });
        // ---- Ir Al Menu de Botanas
        Botanas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BotanasPopulares.class);
                startActivityForResult(intent, 0);
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