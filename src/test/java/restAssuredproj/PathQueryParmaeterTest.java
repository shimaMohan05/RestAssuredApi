package restAssuredproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQueryParmaeterTest {
	//https://reqres.in/api/users?page=2
	//path paramenter: users
	//query parameter: page=2
  @Test
  public void testParams() {
	  given()
	  .pathParams("path", "users")
	  .queryParam("page", "2")
	  
	  .when().get("https://reqres.in/api/{path}")
	  .then()
	  .log().all();
  }
}
