package com.fabcode.miscontactos2.restApi;

/**
 * Created by RGonzales on 11/8/2016.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "16418012.f29379b.dfe3c15f37f749fbb823e960447fd366";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";

    public static final String URL_GET_INFORMATION_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String ROOT_URL_HEROKU = "https://arcane-ridge-94607.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "token-device/";

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=16418012.f29379b.dfe3c15f37f749fbb823e960447fd366

}
