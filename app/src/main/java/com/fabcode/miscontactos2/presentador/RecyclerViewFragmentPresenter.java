package com.fabcode.miscontactos2.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.fabcode.miscontactos2.db.ConstructorContactos;
import com.fabcode.miscontactos2.fragment.IRecyclerViewFragmentView;
import com.fabcode.miscontactos2.pojo.Contacto;
import com.fabcode.miscontactos2.pojo.UsuarioRespuesta;
import com.fabcode.miscontactos2.restApi.EndpointApi;
import com.fabcode.miscontactos2.restApi.adapter.RestApiAdapter;
import com.fabcode.miscontactos2.restApi.model.ContactoResponse;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RGonzales on 10/27/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter() {

    }

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent =  restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointApi endpointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall = endpointApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Algo pasó intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("FALLÓ LA CONEXIÓN", t.toString());
            }
        });
    }

    @Override
    public void enviarToken(String nameId){
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", token);
        enviarTokenRegistro(token, nameId);
    }

    @Override
    public void enviarTokenRegistro(String token, String nameId){
        Log.d("TOKEN", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointApi endpoints = restApiAdapter.establecerConexionApiHeroku();
        Call<UsuarioRespuesta> usuarioRespuestaCall = endpoints.registrarUsuario(token, nameId);
        usuarioRespuestaCall.enqueue(new Callback<UsuarioRespuesta>() {
            @Override
            public void onResponse(Call<UsuarioRespuesta> call, Response<UsuarioRespuesta> response) {
                UsuarioRespuesta usuarioRespuesta = response.body();
                Log.d("ID_FIREBASE ", usuarioRespuesta.getId());
                Log.d("TOKEN_FIREBASE ", usuarioRespuesta.getToken());
                //Log.d("USERID_FIREBASE", nameId);
            }

            @Override
            public void onFailure(Call<UsuarioRespuesta> call, Throwable t) {

            }
        });
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
