package com.fabcode.miscontactos2.restApi;

import com.fabcode.miscontactos2.pojo.Contacto;
import com.fabcode.miscontactos2.pojo.FirebaseRespuesta;
import com.fabcode.miscontactos2.pojo.LikeRespuesta;
import com.fabcode.miscontactos2.pojo.UsuarioRespuesta;
import com.fabcode.miscontactos2.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by RGonzales on 11/8/2016.
 */

public interface EndpointApi {

    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<ContactoResponse> getRecentMedia();

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioRespuesta> registrarUsuario(@Field("token") String token, @Field("userid") String userid);

    @POST(ConstantesRestApi.URL_GET_MEDIA_ID_LIKES)
    Call<LikeRespuesta> enviarLike(@Path("media-id") String media_id);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN_INSTAGRAM)
    Call<FirebaseRespuesta> almacenarLike(@Field("token") String token, @Field("idFoto") String idFoto, @Field("idUsuario") String idUsuario);

    @GET(ConstantesRestApi.KEY_REGISTRO_INSTAGRAM)
    Call<FirebaseRespuesta> notificarLike(@Path("id") String id, @Path("idFoto") String idFoto, @Path("idUsuario") String idUsuario);

}
