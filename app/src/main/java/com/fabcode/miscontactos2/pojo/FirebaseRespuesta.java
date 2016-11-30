package com.fabcode.miscontactos2.pojo;

/**
 * Created by RGonzales on 11/29/2016.
 */

public class FirebaseRespuesta {

    public String id;
    public String token;
    public String idFoto;
    public String idUsuario;

    public FirebaseRespuesta() {
    }

    public FirebaseRespuesta(String id, String token, String idFoto, String idUsuario) {
        this.id = id;
        this.token = token;
        this.idFoto = idFoto;
        this.idUsuario = idUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
