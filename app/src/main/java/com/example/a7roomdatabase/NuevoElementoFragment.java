package com.example.a7roomdatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.a7roomdatabase.databinding.FragmentNuevoElementoBinding;


public class NuevoElementoFragment extends Fragment {
    private FragmentNuevoElementoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentNuevoElementoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
        NavController navController = Navigation.findNavController(view);

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombre.getText().toString();
                String descripcion = binding.descripcion.getText().toString();
                String tipos = binding.tipos.getText().toString();
                String imagen = binding.imagen.getText().toString();

                switch (imagen){
                    case "Pikachu.jpg": case "pikachu.jpg": case "Pikachu.JPG": case "pikachu.JPG":
                    case "Pikachu.PNG": case "pikachu.PNG": case "Pikachu.png": case "pikachu.png":
                        elementosViewModel.insertar(new Elemento(R.drawable.upikachu,nombre,tipos, descripcion));
                        break;
                    case "Snorlax.jpg": case "snorlax.jpg": case "Snorlax.JPG": case "snorlax.JPG":
                    case "Snorlax.PNG": case "snorlax.PNG": case "Snorlax.png": case "snorlax.png":
                        elementosViewModel.insertar(new Elemento(R.drawable.usnorlax,nombre,tipos, descripcion));
                        break;
                    case "Venusaur.JPG": case "venusaur.JPG": case "Venusaur.jpg": case "venusaur.jpg":
                    case "Venusaur.PNG": case "venusaur.PNG": case "Venusaur.png": case "venusaur.png":
                        elementosViewModel.insertar(new Elemento(R.drawable.uvenusaur,nombre,tipos, descripcion));
                        break;
                    case "Mr.mime.JPG": case "mr.mime.JPG": case "Mr.Mime.JPG":case "Mr.mime.PNG": case "mr.mime.PNG": case "Mr.Mime.PNG":
                    case "Mr.mime.jpg": case "mr.mime.jng": case "Mr.Mime.jng":case "Mr.mime.png": case "mr.mime.png": case "Mr.Mime.png":
                        elementosViewModel.insertar(new Elemento(R.drawable.umrmime,nombre,tipos, descripcion));
                        break;
                    case "Lucario.JPG": case "lucario.JPG":case "Lucario.PNG": case "lucario.PNG":
                    case "Lucario.jpg": case "lucario.jpg":case "Lucario.png": case "lucario.png":
                        elementosViewModel.insertar(new Elemento(R.drawable.ulucario,nombre,tipos, descripcion));
                        break;
                    default:
                        elementosViewModel.insertar(new Elemento(R.drawable.misterio,nombre,tipos, descripcion));
                        break;
                }

                navController.popBackStack();
            }
        });
    }
}
