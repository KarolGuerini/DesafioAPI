package com.desafio.rest.tests;

import com.desafio.rest.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Login extends BaseTest {

    @Test

    public void loginSuccessful(){
        Map<String, String> login = new HashMap<>();
        login.put("email", "eve.holt@reqres.in");
        login.put("password", "cityslicka");

        String token = given()
                .body(login)
        .when()
                .post("/login")
        .then()
                .statusCode(200)
                .extract().path("token")
                ;
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token)
        ;


    }

    @Test
    public void loginUnsuccessful(){
        Map<String, String> login = new HashMap<>();
        login.put("email", "peter@klaven");

         given()
                .body(login)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                 .body("error", is("Missing password"))
                ;

    }
}
