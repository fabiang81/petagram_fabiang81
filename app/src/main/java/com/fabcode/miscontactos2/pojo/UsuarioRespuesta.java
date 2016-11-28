package com.fabcode.miscontactos2.pojo;

/**
 * Created by RGonzales on 11/23/2016.
 */

public class UsuarioRespuesta {

    private String id;
    private String token;
    private String userid;

    public UsuarioRespuesta() {
    }

    public UsuarioRespuesta(String id, String token, String userid) {
        this.id = id;
        this.token = token;
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}
