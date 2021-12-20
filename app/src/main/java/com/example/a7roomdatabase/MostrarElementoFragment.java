package com.example.a7roomdatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7roomdatabase.databinding.FragmentMostrarElementoBinding;


public class MostrarElementoFragment extends Fragment {
    private FragmentMostrarElementoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarElementoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        com.example.a7roomdatabase.ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(com.example.a7roomdatabase.ElementosViewModel.class);

        elementosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<com.example.a7roomdatabase.Elemento>() {
            @Override
            public void onChanged(com.example.a7roomdatabase.Elemento elemento) {
                binding.nombre.setText(elemento.nombre);
                binding.tipos.setText(elemento.tipos);
                binding.descripcion.setText(elemento.descripcion);
                binding.valoracion.setRating(elemento.valoracion);
                binding.imagen.setImageResource(elemento.imagen);

                binding.valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        if(fromUser){
                            elementosViewModel.actualizar(elemento, rating);
                        }
                    }
                });
            }
        });
    }
}
