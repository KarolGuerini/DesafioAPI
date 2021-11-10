package com.desafio.rest.tests;

import com.desafio.rest.core.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Resources extends BaseTest {

    @Test
    public void singleResource(){
        given()
                .when()
                .get("/unknown/2")
                .then()
                .statusCode(200)
                .rootPath("data")
                .body("id", is(2))
                .body("name", is("fuchsia rose"))
                .body("year", is(2001))
                .body("color", is("#C74375"))
                .body("pantone_value", is("17-2031"))
        ;

    }

    @Test
    public void listResource(){
        given()
                .when()
                .get("/unknown")
                .then()
                .statusCode(200)
                .body("page", is(1))
                .body("per_page", is(6))
                .body("total", is(12))
                .body("total_pages", is(2))
                .rootPath("data")
                .body("id", hasItems(2,1,4,3,5,6))
                .body("name", hasItems("true red","fuchsia rose","cerulean", "aqua sky",
                        "blue turquoise", "tigerlily"))
                .body("year", hasItems(2005,2001,2004,2003,2005,2000))
                .body("color", hasItems("#53B0AE","#7BC4C4", "#E2583E", "#C74375","#BF1932", "#98B2D1"  ))
                .body("pantone_value", hasItems("17-2031","15-4020", "14-4811", "17-1456","19-1664", "15-5217"  ))

        ;

    }

    @Test
    public void singleResourceNotFound(){
         given()
                .when()
                .get("/unknown/23")
                .then()
                .statusCode(404)
                .body("body", is(nullValue()))
         ;

    }
}
