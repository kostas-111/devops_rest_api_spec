package ru.galkinki;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import io.restassured.RestAssured;
import org.junit.Test;

public class ApiValidationTest {

  private static final OpenApiValidationFilter validationFilter =
      new OpenApiValidationFilter("./swagger.yaml");

  @Test
  public void testSomeEndpoint() {
    RestAssured.given()
        .filter(validationFilter)
        .when()
        .get("http://localhost:8080/calc/")
        .then()
        .assertThat()
        .statusCode(200);
  }
}
