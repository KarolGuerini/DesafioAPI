package com.desafio.rest.tests;

import com.desafio.rest.core.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class Users extends BaseTest {

    @Test
    public void creatUser(){

        Map<String, String> dados = new HashMap<>();
        dados.put("name", "morpheus");
        dados.put("job", "leader");

        given()
                .body(dados)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .body("id", not(isEmptyOrNullString()))
                .body("createdAt", not(isEmptyOrNullString()))
            ;

    }

    @Test
    public void updateUser(){

        Map<String, String> dados = new HashMap<>();
        dados.put("name", "morpheus");
        dados.put("job", "zion resident");

        given()
                .body(dados)
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .body("updatedAt", not(isEmptyOrNullString()))
        ;


    }

    @Test
    public void updateWithPatchUser(){

        Map<String, String> dados = new HashMap<>();
        dados.put("name", "morpheus");
        dados.put("job", "zion resident");

        given()
                .body(dados)
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .body("updatedAt", not(isEmptyOrNullString()))
        ;

    }

    @Test
    public void deleteUser(){
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204)
        ;

    }

    @Test
    public void singleUser(){
         given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                 .body(matchesJsonSchemaInClasspath("singleUser.json"))
         ;

    }

    @Test
    public void singleUserNotFound(){
        given()
                .when()
                .get("/users/23")
                .then()
                .statusCode(404)
                .body("body", is(nullValue()))
        ;

    }

    @Test
    public void listUsers(){
        given()
                .when()
                . get("/users?page=2")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("users.json"))
        ;

    }

    @Test
    public void delayedResponse(){
        given()
                .when()
                . get("/users?page=2")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("delayedResponse.json"))
        ;

    }
}
