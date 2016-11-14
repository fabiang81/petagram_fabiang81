package com.fabcode.miscontactos2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fabcode.miscontactos2.R;
import com.fabcode.miscontactos2.adapter.ContactoAdaptador;
import com.fabcode.miscontactos2.pojo.Contacto;
import com.fabcode.miscontactos2.presentador.IRecyclerViewFragmentPresenter;
import com.fabcode.miscontactos2.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

import static com.fabcode.miscontactos2.R.id.rvContactos;

/**
 * Created by RGonzales on 10/26/2016.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        contactos = new ArrayList<>();

        listaContactos = (RecyclerView) v.findViewById(rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        listaContactos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador contactoAdaptador = new ContactoAdaptador(contactos, getActivity());
        return contactoAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
