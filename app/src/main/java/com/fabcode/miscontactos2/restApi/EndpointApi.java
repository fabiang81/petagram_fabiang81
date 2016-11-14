package com.fabcode.miscontactos2.restApi;

import com.fabcode.miscontactos2.pojo.Contacto;
import com.fabcode.miscontactos2.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RGonzales on 11/8/2016.
 */

public interface EndpointApi {

    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<ContactoResponse> getRecentMedia();

}
