package com.desafio.rest.tests;

import com.desafio.rest.core.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Register extends BaseTest {

    @Test
    public void registerSuccessful() {
        Map<String, String> login = new HashMap<>();
        login.put("email", "eve.holt@reqres.in");
        login.put("password", "pistol");

        given()
                .body(login)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"))
        ;

    }

    @Test
    public void registerUnsuccessful() {
        Map<String, String> login = new HashMap<>();
        login.put("email", "sydney@fife");

        given()
                .body(login)
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"))
        ;


    }
}