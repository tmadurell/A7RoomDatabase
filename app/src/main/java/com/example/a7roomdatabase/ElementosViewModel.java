package com.example.a7roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    com.example.a7roomdatabase.ElementosRepositorio elementosRepositorio;

    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();

    //ViewModel
    MutableLiveData<String> terminoBusqueda = new MutableLiveData<>();

    LiveData<List<Elemento>> resultadoBusqueda = Transformations.switchMap(terminoBusqueda, new Function<String, LiveData<List<Elemento>>>() {
        @Override
        public LiveData<List<Elemento>> apply(String input) {
            return elementosRepositorio.buscar(input);
        }
    });

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new com.example.a7roomdatabase.ElementosRepositorio(application);


    }

    MutableLiveData<Elemento> seleccionado(){
        return elementoSeleccionado;
    }

    LiveData<List<Elemento>> obtener(){
        return elementosRepositorio.obtener();
    }

    //ViewModel
    LiveData<List<Elemento>> masValorados(){
        return elementosRepositorio.masValorados();
    }

    LiveData<List<Elemento>> buscar(){
        return resultadoBusqueda;
    }

    void establecerTerminoBusqueda(String t){
        terminoBusqueda.setValue(t);
    }
    //Final de ViewModel

    void insertar(Elemento elemento){
        elementosRepositorio.insertar(elemento);
    }

    void eliminar(Elemento elemento){
        elementosRepositorio.eliminar(elemento);
    }

    void actualizar(Elemento elemento, float valoracion){
        elementosRepositorio.actualizar(elemento, valoracion);
    }

    void seleccionar(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }





}
