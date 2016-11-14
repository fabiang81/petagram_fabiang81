package com.fabcode.miscontactos2.fragment;

import com.fabcode.miscontactos2.adapter.ContactoAdaptador;
import com.fabcode.miscontactos2.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by RGonzales on 10/26/2016.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
