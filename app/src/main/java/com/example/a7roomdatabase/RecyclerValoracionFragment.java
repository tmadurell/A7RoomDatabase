package com.example.a7roomdatabase;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecyclerValoracionFragment extends com.example.a7roomdatabase.RecyclerElementosFragment {
    @Override
    LiveData<List<Elemento>> obtenerElementos() {
        return elementosViewModel.masValorados();
    }

}
