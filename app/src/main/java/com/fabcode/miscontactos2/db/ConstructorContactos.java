package com.fabcode.miscontactos2.db;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.fabcode.miscontactos2.R;
import com.fabcode.miscontactos2.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by RGonzales on 10/27/2016.
 */

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        //ArrayList<Contacto  > contactos = new ArrayList<>();
        /*contactos.add(new Contacto(R.drawable.pet_04,"Fabián González", "5539292383", "fabiang81@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.pet_16,"Pedro Sanchez", "5539299458", "pedriz@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.pet_20,"Mireya Martinez", "5539959383", "mirey@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.pet_25,"Anahí Salgado", "5535092383", "anai@gmail.com", 9));
        contactos.add(new Contacto(R.drawable.pet_30,"Juan López", "5539456789", "johnygreen@gmail.com", 2));*/

        BaseDatos baseDatos = new BaseDatos(context);
        insertarTresContactos(baseDatos);
        return baseDatos.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos baseDatos){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Fabián González");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5539292383");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "fabiang81@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.pet_04);

        baseDatos.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Pedro Sanchez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5539299458");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "pedriz@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.pet_16);

        baseDatos.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Mireya Martinez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5539959383");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mirey@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.pet_20    );

        baseDatos.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        baseDatos.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesContacto(contacto);
    }

}
