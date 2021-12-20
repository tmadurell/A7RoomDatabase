package com.example.a7roomdatabase;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecyclerBusquedaFragment extends com.example.a7roomdatabase.RecyclerElementosFragment {
    @Override
    LiveData<List<com.example.a7roomdatabase.Elemento>> obtenerElementos() {
        return elementosViewModel.buscar();
    }
}
