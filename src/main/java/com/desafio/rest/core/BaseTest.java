package com.desafio.rest.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.*;

public class BaseTest implements Constantes {

    @BeforeClass

    public static void setup(){

        baseURI = URL_BASE;
        port = PORT;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(CONTENT_TYPE);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        responseSpecification = responseSpecBuilder.build();

        requestSpecBuilder.log(LogDetail.ALL);
        //enableLoggingOfRequestAndResponseIfValidationFails();



    }
}
