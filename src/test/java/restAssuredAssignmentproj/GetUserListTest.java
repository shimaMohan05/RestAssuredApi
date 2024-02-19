package restAssuredAssignmentproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUserListTest {
  @Test
  public void TogetUserList() {
	  given()
	  .when()
	  .get("https://reqres.in/api/users?page=1")
	  .then()
	  .statusCode(200)
	  .body("per_page", equalTo(6))
	  .log().body().log().status();
  }
}
 