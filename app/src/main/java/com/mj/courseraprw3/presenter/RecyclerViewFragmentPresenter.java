package com.mj.courseraprw3.presenter;

import android.content.Context;

import com.mj.courseraprw3.db.ConstructorPets;
import com.mj.courseraprw3.fragment.iRecyclerViewFragmentView;
import com.mj.courseraprw3.pets;

import java.util.ArrayList;


/**
 * Created by leyenda1 on 01/10/2016.
 */

public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {
    private iRecyclerViewFragmentView IRecyclerViewFragmentView;
    private Context context;
    private ConstructorPets constructorPets;
    private ArrayList<pets> pets;

    public RecyclerViewFragmentPresenter(iRecyclerViewFragmentView IRecyclerViewFragmentView, Context context) {
        this.IRecyclerViewFragmentView = IRecyclerViewFragmentView;
        this.context = context;
        getPets();
    }

    @Override
    public void getPets() {
        constructorPets = new ConstructorPets(context);
        pets = constructorPets.obtenerDatos();
        mostrarPetsRV();
    }

    @Override
    public void mostrarPetsRV() {
        IRecyclerViewFragmentView.inicializarAdaptadorRV(IRecyclerViewFragmentView.CrearAdaptador(pets));
        IRecyclerViewFragmentView.generarLinearLayout();
    }
}
