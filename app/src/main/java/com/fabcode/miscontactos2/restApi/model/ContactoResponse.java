package com.fabcode.miscontactos2.restApi.model;

import com.fabcode.miscontactos2.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by RGonzales on 11/8/2016.
 */

public class ContactoResponse {

    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
