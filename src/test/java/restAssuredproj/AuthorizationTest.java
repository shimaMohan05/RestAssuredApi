package restAssuredproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AuthorizationTest {
  @Test(priority=1)
  public void toSetbasicAuthrization() {
	  given()
	  .auth().basic("postman", "password")
	  .when()
	  .get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log().body();
	  
  }
  @Test(priority=2)
  public void toSetDigestAuthrization() {
	  given()
	  .auth().digest("postman", "password")
	  .when()
	  .get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log().body();
	  
  }
  @Test(priority=3)
  public void toSetPreepmtiiveAuthrization() {
	  given()
	  .auth().preemptive().basic("postman", "password")
	  .when()
	  .get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log().body();
	  
  }
  @Test(priority=4)
  public void toSetBearerTokenAuthrization() {
	  given()
	  .header("authorization"," Bearer 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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .statusCode(200)
	  //.body("authenticated",equalTo(true))
	  .log().body();
	  
  }
  @Test(priority=5)
  public void toSetOuth2Authrization() {
	  given().auth().oauth2("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")
	  
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .statusCode(200)
	  //.body("authenticated",equalTo(true))
	  .log().body();
	  
  }
  
}
