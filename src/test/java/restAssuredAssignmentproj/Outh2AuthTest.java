package restAssuredAssignmentproj;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Outh2AuthTest {
  @Test(priority=1)
  public void toSetOuth2() {
 given().auth().oauth2("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")
	  
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .statusCode(200)
	  //.body("authenticated",equalTo(true))
	  .log().body();
	  
  }
}
