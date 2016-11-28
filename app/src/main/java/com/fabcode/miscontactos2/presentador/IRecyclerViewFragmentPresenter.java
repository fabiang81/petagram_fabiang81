package com.fabcode.miscontactos2.presentador;

import com.fabcode.miscontactos2.pojo.Contacto;

/**
 * Created by RGonzales on 10/27/2016.
 */

public interface IRecyclerViewFragmentPresenter {

    public void obtenerContactosBaseDatos();

    public void obtenerMediosRecientes();

    public void enviarToken(String nameId);

    public void enviarTokenRegistro(String token, String nameId);

    public void mostrarContactosRV();
}
