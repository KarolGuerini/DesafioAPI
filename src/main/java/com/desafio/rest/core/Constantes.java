package com.desafio.rest.core;

import io.restassured.http.ContentType;

public interface Constantes {

    String URL_BASE = "https://reqres.in/api";
    Integer PORT = 443;

    ContentType CONTENT_TYPE = ContentType.JSON;

    Long MAX_TIMEOUT = 5000L;

}
