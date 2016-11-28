package com.fabcode.miscontactos2.restApi.adapter;

import com.fabcode.miscontactos2.restApi.ConstantesRestApi;
import com.fabcode.miscontactos2.restApi.EndpointApi;
import com.fabcode.miscontactos2.restApi.deserializador.ContactoDeserializador;
import com.fabcode.miscontactos2.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RGonzales on 11/8/2016.
 */

public class RestApiAdapter {

    public EndpointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        return gsonBuilder.create();
    }

    public EndpointApi establecerConexionApiHeroku(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_HEROKU)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointApi.class);
    }

}
